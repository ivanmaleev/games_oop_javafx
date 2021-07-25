package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        if (free(steps)) {
            figures[index] = figures[index].copy(dest);
            return;
        }
        throw new OccupiedCellException();
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Cell cell : steps) {
            for (Figure figure : figures) {
                if (figure != null &&
                        figure.position().getX() == cell.getX() &&
                        figure.position().getY() == cell.getY()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
