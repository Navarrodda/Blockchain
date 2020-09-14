package blockchain.utn.model;

import blockchain.utn.utils.HashUtils;
import java.time.LocalDateTime;

public class Block {

    private Integer index;
    private Integer nonce = 0;
    private LocalDateTime localDateTime;
    private String previousHash;
    private String hash;
    public String data;

    public Block(Integer index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.localDateTime = LocalDateTime.now();
        this.hash = this.createHash();
    }

    public String createHash(){
        return HashUtils.getHashBlock(this.index + this.nonce + this.localDateTime.toString() + this.data);
    }

    public String getHash() {
        return hash;
    }

    public void mine(String difficulty)
    {
        while(!this.hash.startsWith(difficulty)){
            this.nonce ++;
            this.hash = createHash();
        }
    }
}
