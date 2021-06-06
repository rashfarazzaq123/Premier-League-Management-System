package com.example.demo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface LeagueManager {
  void addFootBallClub(FootballClub footballClub);

  void deleteFootBallClub(String footballClubName);
  ArrayList<FootballClub> display();
  ArrayList<FootballClub> Statistic(String footballStatistic);



  void save() throws IOException, ClassNotFoundException;

  void staticOfThePlayedMatch(String date,String teamOneClub,String teamTwoClub,  int teamOneGoal, int teamTwoGoal) throws ParseException;


  void loaddata() throws IOException;
}

