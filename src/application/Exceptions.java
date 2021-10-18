package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Exceptions {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date CheckIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date CheckOut = sdf.parse(sc.next());
           
            Reservation reservation = new Reservation(number, CheckIn, CheckOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println();
            System.out.println("Enter data to update the reservation");
           
            System.out.print("NEW Check-in date (dd/mm/yyyy): ");
            CheckIn = sdf.parse(sc.next());
            System.out.print("NEW Check-out date (dd/mm/yyyy): ");
            CheckOut = sdf.parse(sc.next());
           
            reservation.updateDates(CheckIn, CheckOut);
            System.out.println("NEW Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Data inválida!");
            System.out.println(e.toString());
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected Error (" + e.getMessage() + ")");
        }
        finally {
            sc.close();
        }
    }
}
