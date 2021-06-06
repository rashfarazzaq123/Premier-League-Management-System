package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FootballResource {
  @Autowired
    private PremierLeagueManager premierLeagueManager;

  @PostMapping("/add/{clubname}/{location}")
  public void addClub(@PathVariable String clubname,String location){
    FootballClub footballClub1=new FootballClub(clubname,location);
    premierLeagueManager.addFootBallClub(footballClub1);
  }

  @GetMapping("/display")
  public ArrayList<FootballClub> getdisplay() {
    return  premierLeagueManager.display();
  }

  @GetMapping("/find/{clubName}")
  public ArrayList<FootballClub> findfootball(@PathVariable String clubName){
  return   premierLeagueManager.Statistic(clubName);
  }

  @DeleteMapping("/delete/{clubName}")
     public void delete(@PathVariable String clubName){
     premierLeagueManager.deleteFootBallClub(clubName);
 }

  @PostMapping("/save")
  public void save() throws IOException, ClassNotFoundException {
    premierLeagueManager.save();

  }

  @GetMapping("/read")
  public void read() throws IOException {
    premierLeagueManager.loaddata();

  }

   @PostMapping("/addmatch/{date}/{teamOne}/{teamtwo}/{teamOneGoal}/{teamTwoGoal}")
  public void addmatch(@PathVariable String date, @PathVariable int teamOneGoal, @PathVariable int teamTwoGoal,
                       @PathVariable String teamtwo, @PathVariable String teamOne) {
     try {
       premierLeagueManager.staticOfThePlayedMatch(date,teamOne,teamtwo,teamOneGoal,teamTwoGoal);
     } catch (ParseException e) {
       e.printStackTrace();
     }
   }

   @PostMapping("/edit/{clubname}/{newclubname}/{wincount}/{drawcount}/{defeatcount}/{noofpoints}")
  public void editdata(@PathVariable String clubname,@PathVariable String newClubname,@PathVariable int wincount,
                       @PathVariable int drawcount,@PathVariable int defeatcount,@PathVariable int noofpoints){
     try {
       premierLeagueManager.editingData(clubname,newClubname,wincount,drawcount,defeatcount,noofpoints);
     } catch (IOException e) {
       e.printStackTrace();
     } catch (InvocationTargetException e) {
       e.printStackTrace();
     }
   }

   @GetMapping("/wincount")
  public ArrayList<FootballClub>   sortwincount(){
   return premierLeagueManager.wincountsort();
   }

  @GetMapping("/goalscored")
  public ArrayList<FootballClub> sortgoalcount(){
    return premierLeagueManager.goalscoredsort();
  }

  @GetMapping("/date")
  public ArrayList<FootballClub> sortdate(){
    return premierLeagueManager.datesort();
  }

  @GetMapping("/random")
  public void randommatch(){
    premierLeagueManager.randommatch();
  }

  @PostMapping("/search/{date}")
  public void search(@PathVariable String date){
    premierLeagueManager.searchData(date);
  }
}
