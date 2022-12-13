public class Ex4 {
    public static void main(String[] args) {
        String[][] field = new String[8][8];
        for (int rows = 0; rows < field.length; rows++) {
            for (int columns = 0; columns < field[rows].length; columns++) {
                field[rows][columns] = "_";
            }
        }
        for (int index = 0; index < field.length; index++) {
            field = placeQueen(field, index, 0);
        }
        System.out.println("Finish");
        printField(field);

    }

    public static void printField(String[][] field) {
        for (int rows = 0; rows < field.length; rows++) {
            for (int columns = 0; columns < field[rows].length; columns++) {
                System.out.print("  " + field[rows][columns] + "  ");
            }
            System.out.println();

        }
        System.out.println("---------------------------------------");
    }

    public static String[][] placeQueen(String[][] field, int row, int start) {
        for (int column = start; column < field[row].length; column++) {
            if (field[row][column].equals("_")) {
                field[row][column] = "Q";
                for (int columnQ = 0; columnQ < field[row].length; columnQ++) {
                    if (field[row][columnQ].equals("_")) {
                        field[row][columnQ] = Integer.toString(row);
                    }
                }
                for (int rowQ = 0; rowQ < field.length; rowQ++) {
                    if (field[rowQ][column].equals("_")) {
                        field[rowQ][column] = Integer.toString(row);
                    }
                }
                int flexibleRow = row;
                int flexibleColumn = column;
                while (flexibleRow < field.length - 1 && flexibleColumn < field[row].length - 1) {
                    flexibleRow++;
                    flexibleColumn++;
                    if (field[flexibleRow][flexibleColumn].equals("_")) {
                        field[flexibleRow][flexibleColumn] = Integer.toString(row);
                    }
                }
                flexibleRow = row;
                flexibleColumn = column;
                while (flexibleRow < field.length - 1 && flexibleColumn > 0) {
                    flexibleRow++;
                    flexibleColumn--;
                    if (field[flexibleRow][flexibleColumn].equals("_")) {
                        field[flexibleRow][flexibleColumn] = Integer.toString(row);
                    }
                }
                System.out.println(row);
                printField(field);
                break;
            } else if (column == field[row].length - 1 && !field[row][column].equals("_")) {
                System.out.println("Error");
                field = moveQueen(field, row - 1);
            }

        }

        return field;
    }

    public static String[][] moveQueen(String[][] field, int row) {
        for (int column = 0; column < field.length; column++) {
            if (field[row][column].equals("Q")) {
                field[row][column] = "_";
                int start = column + 1;
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field[i].length; j++) {
                        if (field[i][j].equals(Integer.toString(row))) {
                            field[i][j] = "_";
                        }
                    }

                }
                System.out.println(row + " deleted");
                printField(field);
                field = placeQueen(field, row, start);
                System.out.println(row + " removed");
                printField(field);
            }
        }

        return field;
    }
}
