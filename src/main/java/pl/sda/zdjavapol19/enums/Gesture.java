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
    SCISSORS,
    PAPER;

    public abstract GameResult play(Gesture other);

}
