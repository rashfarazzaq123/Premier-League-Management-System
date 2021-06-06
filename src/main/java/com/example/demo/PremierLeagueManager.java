package com.example.demo;

import ch.qos.logback.core.BasicStatusManager;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class PremierLeagueManager  implements LeagueManager {


  public ArrayList<FootballClub> getSportsClubArrayList() {
    return sportsClubArrayList;
  }
  ArrayList<FootballClub> matches1 = new ArrayList<>();
  ArrayList<FootballClub>  FootballclubArray= new ArrayList<>();

  Scanner sc = new Scanner(System.in);

  private static ArrayList<FootballClub> sportsClubArrayList = new ArrayList<>();
 // private FootballClub FootballClub;

  @Override
  public void addFootBallClub(FootballClub footballClub) {
    if (sportsClubArrayList.size() < 100) {
      sportsClubArrayList.add(footballClub);
    } else {
      System.out.println("no free slots are available");
    }
  }

  @Override
  public void deleteFootBallClub(String footballClubName) {
    for (FootballClub club : sportsClubArrayList) {
      if (club.getClubName().equals(footballClubName)) {
        sportsClubArrayList.remove(club);
        System.out.println("Club " + club.getClubName() + " removed");
        return;
      }
    }
    System.out.println("No such club in league");
  }

  @Override
  public ArrayList<FootballClub> display() {
 /*   FootballClub footballClub;*/
    Collections.sort(sportsClubArrayList, new FootballClub());
    for (FootballClub club : sportsClubArrayList) {
      System.out.println("Club: " + club.getClubName() + " Points: " + club.getNoPoint() + " goal difference: " +
              (club.getReceivedGoalCount() - club.getScoredGoalCount()));
    }
    return sportsClubArrayList;
  }


  @Override
  public ArrayList<FootballClub> Statistic(String footballStatistic) {
    for (FootballClub club : sportsClubArrayList) {
      if (club.getClubName().equals(footballStatistic)) {
        return sportsClubArrayList;
     /*System.out.println("Club " + club.getClubName() + " name of the club is: " + club.getClubName());
        System.out.println("Club " + club.getClubName() + " matches won: " + club.getWinCount());
        System.out.println("Club " + club.getClubName() + " matches lost: " + club.getDefeatCount());
        System.out.println("Club " + club.getClubName() + " matches draw: " + club.getDrawsCount());
        System.out.println("Club " + club.getClubName() + " scored goals: " + club.getScoredGoalCount());
        System.out.println("Club " + club.getClubName() + " recieved goals: " + club.getScoredGoalCount());
        System.out.println("Club " + club.getClubName() + " points: " + club.getNoPoint());
        System.out.println("Club " + club.getClubName() + " matches played: " + club.getNoMatchesPlayed());*/

      }
    }
    System.out.println("No such club in league");
 return null;
  }
  @Override
  public void save() throws IOException, ClassNotFoundException {
    //===================write the file=====================================================
    try {
      FileOutputStream fileoutputstream = new FileOutputStream("d:\\files\\sports data.txt");
      ObjectOutputStream os = new ObjectOutputStream(fileoutputstream);
      for (FootballClub footballClub : sportsClubArrayList) {
        os.writeObject(footballClub);
      }
      os.flush();
      os.close();
      System.out.println("data have been sucessefully save to the file");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /*a played match with its score and its date, so that the statistics of the two
  clubs involved and the premier league table are updated automatically.
*/
  @Override
  public void staticOfThePlayedMatch(String date,String teamOneClub,String teamTwoClub,  int teamOneGoal, int teamTwoGoal) throws java.text.ParseException {


    FootballClub home = null;
    for(FootballClub club : sportsClubArrayList){
      if(club.getClubName().equals(teamOneClub))
        home = club;
    }
    if (home == null) {
      System.out.println("No such club in league");
      return;
    }

    FootballClub away = null;
    for(FootballClub club : sportsClubArrayList){
      if(club.getClubName().equals(teamTwoClub))
        away = club;
    }
    if (away == null) {
      System.out.println("No such club in league");
      return;
    }


    int homeGoals = -1;
    try {
      homeGoals = teamOneGoal;
    } catch (Exception e) {
    }
    if (homeGoals == -1) {
      System.out.println("You have to enter number of goals");
      return;
    }


    int awayGoals = -1;
    try {
      awayGoals = teamTwoGoal;
    } catch (Exception e) {
    }
    if (awayGoals == -1) {
      System.out.println("You have to enter number of goals");
      return;
    }

FootballClub match=new FootballClub();

    match.setDate(date);
    match.setTeamOne(home);
    match.setTeamTwo(away);
    match.setScoreOfTeamOne(awayGoals);
    match.setScoreOfTeamTwo(homeGoals);
    matches1.add(match);
home.setClubName(teamOneClub);
    home.setScoredGoalCount(home.getScoredGoalCount()+homeGoals);
    away.setScoredGoalCount(away.getScoredGoalCount()+awayGoals);
    home.setReceivedGoalCount(home.getReceivedGoalCount()+awayGoals);
    away.setReceivedGoalCount(away.getReceivedGoalCount()+homeGoals);
    home.setNoMatchesPlayed(home.getNoMatchesPlayed()+1);
    away.setNoMatchesPlayed(away.getNoMatchesPlayed()+1);
   home.setDate(date);
    away.setDate(date);

    if (homeGoals > awayGoals) {
      home.setNoPoint(home.getNoPoint()+3);
      home.setWinCount(home.getWinCount()+1);
      away.setDefeatCount(away.getDefeatCount()+1);
    }

    else if (homeGoals < awayGoals) {
      away.setNoPoint(away.getNoPoint()+3);
      away.setWinCount(away.getWinCount()+1);
      home.setDefeatCount(home.getDefeatCount()+1);
    }
    else {
      home.setNoPoint(home.getNoPoint()+1);
      away.setNoPoint(away.getNoPoint()+1);
      home.setDrawsCount(home.getDrawsCount()+1);
      away.setDrawsCount(away.getDrawsCount()+1);
    }
  }

  public void editingData(String footballClubName,String newfootballclubname,int winCount,int drawsCount,int defeatCount,int noPoint) throws IOException, InvocationTargetException {
    FileInputStream fileinputstream = new FileInputStream("d:\\files\\sports data.txt");
    ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    for (; ; ) {
      try {
        FootballClub footballClub = (FootballClub) ois.readObject();

        System.out.println(sportsClubArrayList + footballClub.getClubName());
        System.out.println("data have been sucessefully loaded to the file");
      } catch (EOFException | ClassNotFoundException e) {
        break;
      }
    }
    for (FootballClub club : sportsClubArrayList) {
      if (club.getClubName().equals(footballClubName)) ;
      club.setClubName(newfootballclubname);
      club.setWinCount(winCount);
      club.setDrawsCount(drawsCount);
      club.setNoPoint(noPoint);
      club.setDefeatCount(defeatCount);
    }
    try {
      FileOutputStream fileoutputstream = new FileOutputStream("d:\\files\\sports data.txt");
      ObjectOutputStream os = new ObjectOutputStream(fileoutputstream);
      for (FootballClub footballClub : sportsClubArrayList) {
        os.writeObject(footballClub);
      }
      os.flush();
      os.close();
      System.out.println("data have been sucessefully save to the file");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void loaddata() throws IOException {
    FileInputStream fileinputstream = new FileInputStream("d:\\files\\sports data.txt");
    ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    for (; ; ) {
      try {
        FootballClub footballClub = (FootballClub) ois.readObject();
        sportsClubArrayList.add(footballClub);
        System.out.println(sportsClubArrayList + footballClub.getClubName());
        System.out.println("data have been sucessefully loaded to the file");
      } catch (EOFException | ClassNotFoundException e) {
        break;
      }
    }
  }

  public ArrayList<FootballClub> wincountsort(){
    Collections.sort(sportsClubArrayList, new Comparator<FootballClub>() {
      @Override
      public int compare(FootballClub o1, FootballClub o2) {

        return o2.getWinCount() - (o1.getWinCount());
      }
    });
    return sportsClubArrayList;
  }

  public ArrayList<FootballClub> goalscoredsort() {
    Collections.sort(sportsClubArrayList, new Comparator<FootballClub>() {
      @Override
      public int compare(FootballClub o1, FootballClub o2) {
        return o2.getScoredGoalCount() - (o1.getScoredGoalCount());
      }
    });
    return sportsClubArrayList;
  }

    public  ArrayList<FootballClub> datesort(){
      Collections.sort(sportsClubArrayList, new Comparator<FootballClub>() {
        DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        @Override
        public int compare(FootballClub o1, FootballClub o2) {
          try {
            return f.parse(o1.getDate()).compareTo(f.parse(o2.getDate()));
          } catch (ParseException e) {
            throw new IllegalArgumentException(e);
          }
        }
      });
      return sportsClubArrayList;
  }
  public void randommatch() {
    int startYear = 2020;
    int endYear = 2022;
    long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
    long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
    long ms = (long) ((end - start) * Math.random() + start);
    Date hireday = new Date(ms);
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormat.format(hireday);
    System.out.println(strDate);
    FootballClub footballmatch = new FootballClub();
    Random random = new Random();
    Random random1 = new Random();
    FootballClub teamTwo = null;
    FootballClub teamOne = null;
    int teamOneGoal = 0;
    int teamTwoGoal = 0;
    for (FootballClub club : sportsClubArrayList) {
      teamOne = sportsClubArrayList.get(random.nextInt(sportsClubArrayList.size()));
      teamTwo = sportsClubArrayList.get(random1.nextInt(sportsClubArrayList.size()));
      club = teamOne;
      club = teamTwo;

    }
    // set the data to the table (randomly generated data)

    System.out.println(teamOne);
    teamOneGoal = random.nextInt(10);
    System.out.println(teamOneGoal);

    System.out.println(teamTwo);
    teamTwoGoal = random1.nextInt(10);
    System.out.println(teamTwoGoal);
    matches1.add(footballmatch);
    footballmatch.setDate(strDate);
    footballmatch.setTeamOne(teamOne);
    footballmatch.setTeamTwo(teamTwo);
    footballmatch.setScoreOfTeamOne(teamOneGoal);
    footballmatch.setScoreOfTeamTwo(teamTwoGoal);
    teamOne.setScoredGoalCount(teamOne.getScoredGoalCount() + teamOneGoal);
    teamTwo.setScoredGoalCount(teamTwo.getScoredGoalCount() + teamTwoGoal);
    teamOne.setReceivedGoalCount(teamOne.getReceivedGoalCount() + teamTwoGoal);
    teamTwo.setReceivedGoalCount(teamTwo.getReceivedGoalCount() + teamOneGoal);
    teamOne.setNoMatchesPlayed(teamOne.getNoMatchesPlayed() + 1);
    teamTwo.setNoMatchesPlayed(teamTwo.getNoMatchesPlayed() + 1);
    teamOne.setDate(strDate);
    teamTwo.setDate(strDate);
    if (teamOneGoal > teamTwoGoal) {
      teamOne.setNoPoint(teamOne.getNoPoint() + 3);
      teamOne.setWinCount(teamOne.getWinCount() + 1);
      teamTwo.setDefeatCount(teamTwo.getDefeatCount() + 1);
    } else if (teamOneGoal < teamTwoGoal) {
      teamTwo.setNoPoint(teamTwo.getNoPoint() + 3);
      teamTwo.setWinCount(teamTwo.getWinCount() + 1);
      teamOne.setDefeatCount(teamOne.getDefeatCount() + 1);
    } else {
      teamOne.setNoPoint(teamOne.getNoPoint() + 1);
      teamTwo.setNoPoint(teamTwo.getNoPoint() + 1);
      teamOne.setDrawsCount(teamOne.getDrawsCount() + 1);
      teamTwo.setDrawsCount(teamTwo.getDrawsCount() + 1);
    }
  }
  public void searchData(String search)  {
    for (FootballClub club:sportsClubArrayList){
      if (club.getDate().equals(search)){
        FootballclubArray.add(club);
      }
    }
  }
  }

