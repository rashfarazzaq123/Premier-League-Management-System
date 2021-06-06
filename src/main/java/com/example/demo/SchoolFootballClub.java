package com.example.demo;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub  {

  private String schoolName;

  public SchoolFootballClub(){}

  public SchoolFootballClub(String schoolName) {
    this.schoolName = schoolName;
  }

  public SchoolFootballClub(String clubName, String location, String schoolName) {
    super(clubName, location);
    this.schoolName = schoolName;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

 /* @Override
  public FootballClub getTeamOne() {
    return super.getTeamOne();
  }

  @Override
  public FootballClub getTeamTwo() {
    return super.getTeamTwo();
  }
*/
  public SchoolFootballClub(String clubName, String location) {
    super(clubName, location);
  }

  /*@Override
  public int getScoreOfTeamOne() {
    return super.getScoreOfTeamOne();
  }

  @Override
  public int getScoreOfTeamTwo() {
    return super.getScoreOfTeamTwo();
  }

  @Override
  public String getDate() {
    return super.getDate();
  }

  @Override
  public void setTeamOne(FootballClub teamOne) {
    super.setTeamOne(teamOne);
  }

  @Override
  public void setTeamTwo(FootballClub teamTwo) {
    super.setTeamTwo(teamTwo);
  }

  @Override
  public void setScoreOfTeamOne(int scoreOfTeamOne) {
    super.setScoreOfTeamOne(scoreOfTeamOne);
  }

  @Override
  public void setScoreOfTeamTwo(int scoreOfTeamTwo) {
    super.setScoreOfTeamTwo(scoreOfTeamTwo);
  }

  @Override
  public void setDate(String date) {
    super.setDate(date);
  }
*/
  @Override
  public String getClubName() {
    return super.getClubName();
  }

  @Override
  public void setClubName(String clubName) {
    super.setClubName(clubName);
  }

  @Override
  public String getLocation() {
    return super.getLocation();
  }

  @Override
  public void setLocation(String location) {
    super.setLocation(location);
  }

  @Override
  public int getWinCount() {
    return super.getWinCount();
  }

  @Override
  public void setWinCount(int winCount) {
    super.setWinCount(winCount);
  }

  @Override
  public int getDrawsCount() {
    return super.getDrawsCount();
  }

  @Override
  public void setDrawsCount(int drawsCount) {
    super.setDrawsCount(drawsCount);
  }

  @Override
  public int getDefeatCount() {
    return super.getDefeatCount();
  }

  @Override
  public void setDefeatCount(int defeatCount) {
    super.setDefeatCount(defeatCount);
  }

  @Override
  public int getScoredGoalCount() {
    return super.getScoredGoalCount();
  }

  @Override
  public void setScoredGoalCount(int scoredGoalCount) {
    super.setScoredGoalCount(scoredGoalCount);
  }

  @Override
  public int getReceivedGoalCount() {
    return super.getReceivedGoalCount();
  }

  @Override
  public void setReceivedGoalCount(int receivedGoalCount) {
    super.setReceivedGoalCount(receivedGoalCount);
  }

  @Override
  public int getNoPoint() {
    return super.getNoPoint();
  }

  @Override
  public void setNoPoint(int noPoint) {
    super.setNoPoint(noPoint);
  }

  @Override
  public int getNoMatchesPlayed() {
    return super.getNoMatchesPlayed();
  }

  @Override
  public void setNoMatchesPlayed(int noMatchesPlayed) {
    super.setNoMatchesPlayed(noMatchesPlayed);
  }



  @Override
  public String toString() {
    return "SchoolFootballClub{" +
            "schoolName='" + schoolName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof SchoolFootballClub))
      return false;
    SchoolFootballClub that = (SchoolFootballClub) o;
    return
            getSchoolName().equals(that.getSchoolName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSchoolName());
  }
}
