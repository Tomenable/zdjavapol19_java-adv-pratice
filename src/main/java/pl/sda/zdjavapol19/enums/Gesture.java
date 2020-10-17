package pl.sda.zdjavapol19.enums;

public enum Gesture {

    ROCK {
        @Override
        public GameResult play(Gesture other) {
            switch(other) {
                case PAPER:
                    return GameResult.LOSE;
                case SCISSORS:
                    return GameResult.WIN;
                case ROCK:
                    return GameResult.DRAW;
                default:
                    return GameResult.DRAW; //wiemy, ze sie nie wykona, ale potrzebne do kompilacji
            }
        }
    },
    SCISSORS {
        @Override
        public GameResult play(Gesture other) {
            switch(other) {
                case PAPER:
                    return GameResult.WIN;
                case SCISSORS:
                    return GameResult.DRAW;
                case ROCK:
                    return GameResult.LOSE;
                default:
                    return GameResult.DRAW; //wiemy, ze sie nie wykona, ale potrzebne do kompilacji
            }
        }
    },
    PAPER {
        @Override
        public GameResult play(Gesture other) {
            switch(other) {
                case PAPER:
                    return GameResult.DRAW;
                case SCISSORS:
                    return GameResult.LOSE;
                case ROCK:
                    return GameResult.WIN;
                default:
                    return GameResult.DRAW; //wiemy, ze sie nie wykona, ale potrzebne do kompilacji
            }
        }
    };

    public abstract GameResult play(Gesture other);

}
