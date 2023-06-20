package de.tum.in.ase.eist;

import java.util.concurrent.locks.ReentrantLock;

public class SwimmingPool {
    private final ChangingRoom changingRoom;
    private final Locker locker;
    private int totalVisitors;
    private final ReentrantLock totalVisitorsLock;

    public SwimmingPool() {
        this.changingRoom = new ChangingRoom();
        this.locker = new Locker();
        this.totalVisitors = 0;
        this.totalVisitorsLock = new ReentrantLock();
    }

    public void handleEntryRequest(Swimmer swimmer, SwimmingPoolActionOrder order) {
        switch (order) {
            case CHANGING_ROOM_BEFORE_LOCKER -> {
                changingRoom.acquireKey(swimmer);
                locker.storeClothes(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                locker.retrieveClothes();
                changingRoom.releaseKey();
            }
            case LOCKER_BEFORE_CHANGING_ROOM -> {
                locker.storeClothes(swimmer);
                changingRoom.acquireKey(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                changingRoom.releaseKey();
                locker.retrieveClothes();
            }
        }
        totalVisitorsLock.lock();
        totalVisitors++;
        totalVisitorsLock.unlock();
    }

    public void handleEntryRequestDeadlockFree(Swimmer swimmer, SwimmingPoolActionOrder order) {
        totalVisitorsLock.lock();

        if (totalVisitors == 0) {
            switch (order) {
                case CHANGING_ROOM_BEFORE_LOCKER -> {
                    changingRoom.acquireKey(swimmer);
                    locker.storeClothes(swimmer);

                    System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                    locker.retrieveClothes();
                    changingRoom.releaseKey();
                }
                case LOCKER_BEFORE_CHANGING_ROOM -> {
                    locker.storeClothes(swimmer);
                    changingRoom.acquireKey(swimmer);

                    System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                    changingRoom.releaseKey();
                    locker.retrieveClothes();
                }
            }
            totalVisitors++;
        } else {
            System.out.printf("Swimmer %d is not allowed entry as another swimmer is currently swimming.\n", swimmer.getId());
        }

        totalVisitorsLock.unlock();
    }

    public int getTotalVisitors() {
        return this.totalVisitors;
    }
}
