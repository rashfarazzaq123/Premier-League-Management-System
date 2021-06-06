package com.example.demo;

import java.util.Objects;

public class SportsClub {
 private String clubName;
  private String location;
  private int Statistic;
  public SportsClub() {

  }

  public SportsClub(String clubName, String location) {
    this.clubName = clubName;
    this.location = location;

  }

  public String getClubName() {
    return clubName;
  }

  public int getStatistic() {
    return Statistic;
  }

  public void setStatistic(int statistic) {
    Statistic = statistic;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof SportsClub))
      return false;
    SportsClub that = (SportsClub) o;
    return getStatistic() == that.getStatistic() &&
            getClubName().equals(that.getClubName()) &&
            getLocation().equals(that.getLocation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClubName(), getLocation(), getStatistic());
  }

  @Override
  public String toString() {
    return "SportsClub{" +
            "clubName='" + clubName + '\'' +
            ", location='" + location + '\'' +
            ", Statistic=" + Statistic +
            '}';
  }
}
