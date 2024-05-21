package Assignments;

public class MovieTheater {
    private char[][] seats;

    public MovieTheater(int rows, int cols) {
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = '0';
            }
        }
    }

    // display the seating chart
    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // reserve a seat
    public void reserveSeat(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("Invalid seat location.");
            return;
        }
        if (seats[row][col] == 'X') {
            System.out.println("Seat (" + row + ", " + col + ") is already taken.");
        } else {
            seats[row][col] = 'X';
            System.out.println("Seat (" + row + ", " + col + ") has been reserved.");
        }
    }

    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater(5, 5);

        theater.displaySeatingChart();

        theater.reserveSeat(2, 3);
        theater.displaySeatingChart();

        theater.reserveSeat(2, 3); 
        theater.displaySeatingChart();

        theater.reserveSeat(4, 4);
        theater.displaySeatingChart();

        theater.reserveSeat(5, 5); 
        theater.displaySeatingChart();
    }
}

