package blockchain.utn;

import blockchain.utn.model.Block;
import blockchain.utn.model.BlockChain;
import blockchain.utn.utils.HashUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

	public static void main(String[] args) {
		 BlockChain newBlockChain = new BlockChain("00");
		 newBlockChain.addBlock("UTN");
		 newBlockChain.addBlock("Seminario");
		 newBlockChain.addBlock("Poc");
		 System.out.println(newBlockChain.chain);
		 System.out.println(newBlockChain.isChainValid());
		 newBlockChain.chain.get(1).data = "POC";
		 System.out.println(newBlockChain.isChainValid());

		//SpringApplication.run(BlockchainApplication.class, args);
	}

}
