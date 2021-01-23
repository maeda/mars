package com.universe.milkway.solarsystem.mars;

public enum Orientation {
    N {
        @Override
        public Orientation change(Direction direction) {
            return Direction.L.equals(direction) ? Orientation.W : Orientation.E;
        }
    },
    S {
        @Override
        public Orientation change(Direction direction) {
            return Direction.L.equals(direction) ? Orientation.E : Orientation.W;
        }
    },
    E {
        @Override
        public Orientation change(Direction direction) {
            return Direction.L.equals(direction) ? Orientation.N : Orientation.S;
        }
    },
    W {
        @Override
        public Orientation change(Direction direction) {
            return Direction.L.equals(direction) ? Orientation.S : Orientation.N;
        }
    };

    public abstract Orientation change(Direction direction);
}
