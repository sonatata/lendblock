package lendblock;
package org.aion.avm;

import org.aion.avm.api.ABIDecoder;
import org.aion.avm.api.Address;
import org.aion.avm.api.BlockchainRuntime;
import org.aion.avm.userlib.AionMap;
import org.aion.avm.userlib.AionSet;

public class Lendable {
	public static Address lender;
	public static Address lendee;

	public static int lendDate;
	public static int returnDate;
	public Bool public lended;
	public static int itemValue;
	public Bool available;
	// uint public minLendTime;
	// uint public maxLendTime;
	// uint constant MIN_LEND_TIME = 60;
	// uint constant MAX_LEND_TIME = 3600 * 24 * 365;

	static {
        lender = BlockchainRuntime.getCaller();
        available = true;
  		timestamp = BlockchainRuntime.getBlockTimestamp();
    }

	private static void onlyLender(){
        BlockchainRuntime.require(lender.equals(BlockchainRuntime.getCaller()));
    }

    private static void onlyLendee(){
        BlockchainRuntime.require(lendee.equals(BlockchainRuntime.getCaller()));
    }

	private static void whenNotLended(){
        BlockchainRuntime.require(!lended || timestamp > returnDate);
    }

    private static void whenLended(){
        BlockchainRuntime.require(lended && timestamp <= returnDate);
    }

    private static void ifAvailable(){
        BlockchainRuntime.require(available);
    }

   	public static setAvailable(Bool _available) {
   		onlyLender();
		available = _available;
	}

	// sent by lendee, specifies lendDate 
	public static lendRequest(int _returnDate, ) {
		ifAvailable();
		whenNotLended();

		BlockchainRuntime.require( > 0);
		BlockchainRuntime.require(itemValue > 0);


		returnDate = _returnDate;
		lended = true;
		lendee = BlockchainRuntime.getCaller();
		lendDate = timestamp;
	}


}

pragma solidity >=0.4.22 <0.6.0;

//
// Permissions
//
//                                      Lender    Lendee   Anyone
// Initialize                             x
// Setup                                  x
// Set value of item lended price         x
// Make available/unavailable             x
// Force lend end (after period)          x
// Call function with onlyLendee                   x
// End lending before return time                  x
// Lend                                                      x


contract Lendable {
	
	address public lender;
	address public lendee;
	uint public lendDate;
	uint public returnDate;
	bool public lended;
	uint public itemValue;
	uint public minLendTime;
	uint public maxLendTime;
	uint constant MIN_LEND_TIME = 60;
	uint constant MAX_LEND_TIME = 3600 * 24 * 365;
	bool public available;

	event E_Lend(address indexed_lender, uint _lendDate, uint _returnDate, uint _itemValue);
	event E_ReturnLendedItem(address indexed _lender, uint _returnDate);


	modifier onlyLender() {
		require(msg.sender == lender);
		_;
	}
	modifier onlyLendee() {
		require(msg.sender == lendee);
		_;
	}
	modifier whenNotLended() {
		require(!lended || now > returnDate);
		_;
	}
	modifier whenLended() {
		require(lended && now <= returnDate);
		_;
	}
	modifier ifAvailable() {
		require(available);
		_;
	}

	constructor() public {
		lender = msg.sender;
	}

	function lendSetup(uint _minLendTime, uint _maxLendTime) public onlyLender {
		require(!available);
		require(_minLendTime >= MIN_LEND_TIME &&
				_maxLendTime <= MAX_LEND_TIME &&
				_minLendTime < _maxLendTime);
		available = true;
		minLendTime = _minLendTime;
		maxLendTime = _maxLendTime;
	}

	function setAvailable(bool _available) public onlyLender {
		available = _available;
	}

	function lendRequest() public payable ifAvailable whenNotLended {
		require(msg.value > 0);
		require(itemValue > 0); //make sure item value was set

		uint lendTime = msg.value / itemValue;
		require(lendTime >= minLendTime && lendTime <= maxLendTime);

		returnDate = now + lendTime;

		lended = true;
		lendee = msg.sender;
		lendDate = now;

		emit E_Lend(lendee, lendDate, returnDate, itemValue);
	}

	function lendElapsedTime() public view whenLended returns (uint) {
		return now - lendDate;
	}

	function lendTimeRemaining() public view whenLended returns (uint){
        return (returnDate - now);
    }

    function lendingTotalTime() public view whenLended returns (uint){
        return (returnDate - lendDate);
    }

    function forceLendEnd() public onlyLender{
        require(now > returnDate && lended);
        emit E_ReturnLendedItem(lendee, now);
        // if lendee does not return item, its value is transfered to the lender
        msg.sender.transfer(itemValue);
        resetLending();
    }

    function returnLendedItem() public onlyLendee whenLended {

    	// when item is returned, we no longer need to hold item value and can release funds
    	msg.sender.transfer(itemValue);

    	emit E_ReturnLendedItem(lendee, now);

    	resetLending();
    }

    /// @dev resets the rental variables
    function resetLending() private{
        lended = false;
        lendee = address(0);
        lendDate = 0;
        lendDate = 0;
    }
}