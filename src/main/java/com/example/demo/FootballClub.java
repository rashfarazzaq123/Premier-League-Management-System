package com.example.demo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparator<FootballClub>, Serializable {
  private int winCount;
  private int drawsCount;
  private int defeatCount;
  private int scoredGoalCount;
  private int receivedGoalCount;
  private int noPoint;
  private int noMatchesPlayed;
  // private  String clubName;



  // attributes which are used for  the played match method

  private FootballClub teamOne;
  private FootballClub teamTwo;
  private int scoreOfTeamOne;
  private int scoreOfTeamTwo;

  private String date;
  public FootballClub(){
  }

  public FootballClub(String clubName, String location, int winCount, int drawsCount, int defeatCount, int scoredGoalCount, int receivedGoalCount, int noPoint) {
    super(clubName, location);
    this.winCount = winCount;
    this.drawsCount = drawsCount;
    this.defeatCount = defeatCount;
    this.scoredGoalCount = scoredGoalCount;
    this.receivedGoalCount = receivedGoalCount;
    this.noPoint = noPoint;
  }

  public FootballClub getTeamOne() {
    return teamOne;
  }

  public FootballClub getTeamTwo() {
    return teamTwo;
  }

  public FootballClub(String clubName, String location) {
    super(clubName, location);
  }

  public int getScoreOfTeamOne(){
    return scoreOfTeamOne;
  }

  public int getScoreOfTeamTwo(){
    return scoreOfTeamTwo;
  }

  @Override
  public String getClubName() {
    return super.getClubName();
  }

  @Override
  public int getStatistic() {
    return super.getStatistic();
  }

  @Override
  public void setStatistic(int statistic) {
    super.setStatistic(statistic);
  }

  @Override
  public void setClubName(String clubName) {
    super.setClubName(clubName);
  }

  public String getDate() {
    return date;
  }

  public void setTeamOne(FootballClub teamOne) {
    this.teamOne = teamOne;
  }

  public void setTeamTwo(FootballClub teamTwo) {
    this.teamTwo = teamTwo;
  }

  public void setScoreOfTeamOne(int scoreOfTeamOne) {
    this.scoreOfTeamOne = scoreOfTeamOne;
  }

  public void setScoreOfTeamTwo(int scoreOfTeamTwo) {
    this.scoreOfTeamTwo = scoreOfTeamTwo;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String getLocation() {
    return super.getLocation();
  }

  @Override
  public void setLocation(String location) {
    super.setLocation(location);
  }

  public int getWinCount() {
    return winCount;
  }

  public void setWinCount(int winCount) {
    this.winCount = winCount;
  }

  public int getDrawsCount() {
    return drawsCount;
  }

  public void setDrawsCount(int drawsCount) {
    this.drawsCount = drawsCount;
  }

  public int getDefeatCount() {
    return defeatCount;
  }

  public void setDefeatCount(int defeatCount) {
    this.defeatCount = defeatCount;
  }

  public int getScoredGoalCount() {
    return scoredGoalCount;
  }

  public void setScoredGoalCount(int scoredGoalCount) {
    this.scoredGoalCount = scoredGoalCount;
  }

  public int getReceivedGoalCount() {
    return receivedGoalCount;
  }

  public void setReceivedGoalCount(int receivedGoalCount) {
    this.receivedGoalCount = receivedGoalCount;
  }

  public int getNoPoint() {
    return noPoint;
  }

  public void setNoPoint(int noPoint) {
    this.noPoint = noPoint;
  }

  public int getNoMatchesPlayed() {
    return noMatchesPlayed;
  }

  public void setNoMatchesPlayed(int noMatchesPlayed) {
    this.noMatchesPlayed = noMatchesPlayed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    FootballClub that = (FootballClub) o;
    return winCount == that.winCount &&
            drawsCount == that.drawsCount &&
            defeatCount == that.defeatCount &&
            scoredGoalCount == that.scoredGoalCount &&
            receivedGoalCount == that.receivedGoalCount &&
            noPoint == that.noPoint &&
            noMatchesPlayed == that.noMatchesPlayed &&
            scoreOfTeamOne == that.scoreOfTeamOne &&
            scoreOfTeamTwo == that.scoreOfTeamTwo &&
            Objects.equals(teamOne, that.teamOne) &&
            Objects.equals(teamTwo, that.teamTwo) &&
            Objects.equals(date, that.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), winCount, drawsCount, defeatCount, scoredGoalCount, receivedGoalCount, noPoint, noMatchesPlayed, teamOne, teamTwo, scoreOfTeamOne, scoreOfTeamTwo, date);
  }

  @Override
  public String toString() {
    return "FootballClub{" +
            "winCount=" + winCount +
            ", drawsCount=" + drawsCount +
            ", defeatCount=" + defeatCount +
            ", scoredGoalCount=" + scoredGoalCount +
            ", receivedGoalCount=" + receivedGoalCount +
            ", noPoint=" + noPoint +
            ", noMatchesPlayed=" + noMatchesPlayed +
            ", teamOne=" + teamOne +
            ", teamTwo=" + teamTwo +
            ", scoreOfTeamOne=" + scoreOfTeamOne +
            ", scoreOfTeamTwo=" + scoreOfTeamTwo +
            ", date='" + date + '\'' +
            '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public int compare(FootballClub t, FootballClub t1) {
    if (t.getNoPoint() > t1.getNoPoint())
      return -1;
    else if (t.getNoPoint() < t1.getNoPoint())
      return 1;
    else {
      int goalDif = t.getScoredGoalCount() - t.getReceivedGoalCount();
      int goalDif1 = t1.getScoredGoalCount() - t1.getReceivedGoalCount();
      if (goalDif > goalDif1)
        return -1;
      else if (goalDif < goalDif1)
        return 1;
      else return 0;
      // return Integer.compare(goalDifferenceOne, goalDifference);
    }
  }

}

