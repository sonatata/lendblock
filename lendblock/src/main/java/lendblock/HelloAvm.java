package lendblock;

import org.aion.avm.api.ABIDecoder;
import org.aion.avm.api.BlockchainRuntime;

public class HelloAvm
{
    public static void sayHello() {
        BlockchainRuntime.println("Hello Avm");
    }

    public static String greet(String name) {
    	return "Good morning " + name;
	}

    public static byte[] main() {
        return ABIDecoder.decodeAndRunWithClass(HelloAvm.class, BlockchainRuntime.getData());
    }
}
