package com.shivam.learn.reflection.modifiers;

import java.util.*;

/**
 * @author sksingh created on 04/01/24
 */
public class Auction {

    private final List<Bid> bids = new ArrayList<>();

    private transient volatile boolean isAuctionStarted;

    public synchronized void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public synchronized List<Bid> getAllBids() {
        return Collections.unmodifiableList(bids);
    }

    public synchronized Optional<Bid> getHighestBid() {
        return bids.stream().max(Comparator.comparing(Bid::getPrice));
    }

    public void startAuction() {
        this.isAuctionStarted = true;
    }

    public void stopAuction() {
        this.isAuctionStarted = false;
    }

    public boolean isAuctionRunning() {
        return this.isAuctionStarted;
    }

}
