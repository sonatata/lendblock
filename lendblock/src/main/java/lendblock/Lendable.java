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

	// private static void whenNotLended(){
  //       BlockchainRuntime.require(!lended || timestamp > returnDate);
  //   }

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

		BlockchainRuntime.require( > 0);
		BlockchainRuntime.require(itemValue > 0);


		returnDate = _returnDate;
		lended = true;
		lendee = BlockchainRuntime.getCaller();
		lendDate = timestamp;
	}


}
