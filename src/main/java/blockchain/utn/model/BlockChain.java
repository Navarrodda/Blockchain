package blockchain.utn.model;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    public List<Block> chain;
    private String difficulty = "00";

    public BlockChain(String difficulty) {
        this.difficulty = difficulty;
        this.chain = new ArrayList<Block>();
        this.chain.add(this.createFirstBlock());
    }

    private Block createFirstBlock(){
        return  new Block(0,"This is block 0", "");
    }

    public void addBlock(String data){
        Block prev = this.getLastBlock();
        Block newBlock = new Block(this.chain.size(),data,prev.getHash());
        newBlock.mine(this.difficulty);
        this.chain.add(newBlock);
    }

    private Block getLastBlock(){
        return this.chain.get(this.chain.size() - 1);
    }

    public boolean isChainValid(){
        for (int i = 1; i < this.chain.size(); i ++ ){
            Block now = this.chain.get(i);
            Block previos = this.chain.get(i-1);
            if(!previos.getHash().equals(now.getHash())){
                return false;
            }
            if (now.getHash().equals(now.createHash())){
                return false;
            }
        }
        return true;
    }

}
