package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {

  PremierLeagueManager  premierLeagueManager = new PremierLeagueManager();
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //premierLeagueManager.loaddata();
     System.out.println("hello welcome to the football managment system");
      System.out.println("choose  what you want from here");
      System.out.println("for add clubs type 1 ");
      System.out.println("to  delete clubs type 2 ");
      System.out.println("to display the pesific type of a club detail(statistic)type 3 ");
      System.out.println("for display the statistic of the club type 4 ");
      System.out.println("to enter the match details for the club type 5 ");
      System.out.println("for save the club details type 6");
      System.out.println("to edit the save data  type 7 ");
      System.out.println("to display the data in a table type 8  ");
      Scanner sc = new Scanner(System.in);
      while (true) {
        System.out.println("enter a  number");
        int choise = sc.nextInt();
        if (choise == 1) {
          System.out.println("enter the age type you want to enter");
          int clubChoice = sc.nextInt();
          if (clubChoice < 18) {
            System.out.println("Insert school name: ");
            String schoolName = sc.next();
            System.out.println("Insert club name: ");
            String clubName = sc.next();
            System.out.println("Insert location: ");
            String location = sc.next();
            SchoolFootballClub schoolFootballClub = new SchoolFootballClub(clubName, location, schoolName);
            premierLeagueManager.addFootBallClub(schoolFootballClub);
           // footballResource.addClub(schoolFootballClub);

          } else if (clubChoice < 23 && clubChoice > 18) {
            System.out.println("Insert university name: ");
            String uniName = sc.next();
            System.out.println("Insert club name: ");
            String clubName = sc.next();
            System.out.println("Insert location: ");
            String location = sc.next();
            UniversityFootballClub universityFootballClub = new UniversityFootballClub(uniName, clubName, location);
            premierLeagueManager.addFootBallClub(universityFootballClub);
            //footballResource.addClub(universityFootballClub);
          } else {
            System.out.println("Insert club name: ");
            String clubName = sc.next();
            System.out.println("Insert location: ");
            String location = sc.next();
            FootballClub footballClub = new FootballClub(clubName, location);
            premierLeagueManager.addFootBallClub(footballClub);
         //   footballResource.addClub(footballClub);
          }
        } else if (choise == 2) {
          System.out.println("enter the club name");
          String clubName = sc.next();
          premierLeagueManager.deleteFootBallClub(clubName);

        }else if (choise == 3) {
          System.out.println("Insert club name: ");
          String footballclubStatictic = sc.next();
          premierLeagueManager.Statistic(footballclubStatictic);
        } else if (choise == 4) {
          premierLeagueManager.display();

      } else if (choise == 5) {
          System.out.println("Enter the date: ");
          String date = sc.next();

          System.out.println("Enter Team one: ");
          String teamOneClub = sc.next();
          System.out.println("Enter Team two: ");
          String teamTwoClub = sc.next();
          System.out.println("Enter teamOne team goals: ");
          int teamOneGoal = sc.nextInt();
          System.out.println("Enter teamTwo team goals: ");
          int teamTwoGoal = sc.nextInt();

          premierLeagueManager.staticOfThePlayedMatch(date,teamOneClub,teamTwoClub,teamOneGoal,teamTwoGoal);
    } else if (choise == 6) {
      premierLeagueManager.save();
    } else if (choise == 7) {
      System.out.println("Insert club name: ");
      String clubName = sc.next();
      System.out.println("Insert new club name: ");
      String newclubName = sc.next();
      System.out.println("Insert wincount: ");
      int wincount = sc.nextInt();
      System.out.println("Insert draw count: ");
      int drawCount = sc.nextInt();
      System.out.println("Insert defeat count: ");
      int defeatCount = sc.nextInt();
      System.out.println("Insert no of points: ");
      int noOfPoint = sc.nextInt();
      premierLeagueManager.editingData(clubName,newclubName,wincount,drawCount,defeatCount,noOfPoint);
    } else if (choise == 8) {
          premierLeagueManager.randommatch();
    } else {
      System.out.println("enter correct letter");
    }

    }
  }
}
