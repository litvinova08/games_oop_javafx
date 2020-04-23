package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        int step = 1;
        for (int index = 0; index < size; index++) {
            if (deltaX > 0) { //means source x > dest x
                int x = source.x - step;
                if (deltaY > 0) {
                    int y = source.y - step;
                    steps[index] = Cell.findBy(x, y);
                    step++;
                } else {
                    int y = source.y + step;
                    steps[index] = Cell.findBy(x, y);
                    step++;
                }
            } else {
                int x = source.x + step;
                if (deltaY > 0) {
                    int y = source.y - step;
                    steps[index] = Cell.findBy(x, y);
                    step++;
                } else {
                    int y = source.y + step;
                    steps[index] = Cell.findBy(x, y);
                    step++;
                }
            }
        }
        //если убираю комментирование с исключения, тест выдает stackoverflowerror. Почему так получается?
//        if (!isDiagonal(source, dest)) {
//            throw new IllegalStateException(
//                    String.format("Could not move by diagonal from %s to %s", source, dest)
//            );
//        }
        return steps;
    }


    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        Cell[] temp = way(source, dest);
        for (int i = 1; i < temp.length - 1; i++) {
            if (Math.abs(temp[i].x - temp[i + 1].x) == 1 && Math.abs(temp[i].y - temp[i + 1].y) == 1) {
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
