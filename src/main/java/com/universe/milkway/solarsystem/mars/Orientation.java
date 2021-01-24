package com.universe.milkway.solarsystem.mars;

public enum Orientation {
    N {
        @Override
        public Orientation change(Direction direction) {
            return Direction.LEFT.equals(direction) ? Orientation.W : Orientation.E;
        }

        @Override
        public Geolocation move(Geolocation geolocation) {
            return new Geolocation(geolocation.getX(), geolocation.getY() + 1);
        }
    },
    S {
        @Override
        public Orientation change(Direction direction) {
            return Direction.LEFT.equals(direction) ? Orientation.E : Orientation.W;
        }

        @Override
        public Geolocation move(Geolocation geolocation) {
            return new Geolocation(geolocation.getX(), geolocation.getY() - 1);
        }
    },
    E {
        @Override
        public Orientation change(Direction direction) {
            return Direction.LEFT.equals(direction) ? Orientation.N : Orientation.S;
        }

        @Override
        public Geolocation move(Geolocation geolocation) {
            return new Geolocation(geolocation.getX() + 1, geolocation.getY());
        }
    },
    W {
        @Override
        public Orientation change(Direction direction) {
            return Direction.LEFT.equals(direction) ? Orientation.S : Orientation.N;
        }

        @Override
        public Geolocation move(Geolocation geolocation) {
            return new Geolocation(geolocation.getX() - 1, geolocation.getY());
        }
    };

    public abstract Orientation change(Direction direction);
    public abstract Geolocation move(Geolocation geolocation);
}
