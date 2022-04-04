package com.bigo.whattypeofdev.global.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_survey_record")
public class SurveyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyRecordId;

    @Column(name = "aboutme_dev")
    private int aboutmeDev;

    @Column(name="aboutme_dev_type")
    private int aboutmeDevType;

    @Column(name="aboutme_age")
    private int aboutmeAge;

    @Column(name="aboutme_gender")
    private int aboutmeGender;

    @Column(name="aboutme_salary")
    private int aboutmeSalary;

    @Column(name="aboutme_work")
    private int aboutmeWork;

    @Column(name="aboutme_mobile")
    private int aboutmeMobile;

    @Column(name="dev_headphone")
    private int devHeadphone;

    @Column(name="dev_eat")
    private int devEat;

    @Column(name="dev_drink")
    private int devDrink;

    @Column(name="dev_team_size")
    private int devTeamSize;

    @Column(name="dev_worktime")
    private int devWorktime;

    @Column(name="moral_cctv")
    private int moralCctv;

    @Column(name="moral_rule")
    private int moralRule;

    @Column(name="moral_help")
    private int moralHelp;

    @Column(name = "moral_gov_protection")
    private int moralGovProtection;

    @Column(name = "moral_manner")
    private int moralManner;

    @Column(name = "moral_environment")
    private int moralEnvironment;

    @Column(name = "relation_equal")
    private int relationEqual;

    @Column(name="relation_understand")
    private int relationUnderstand;

    @Column(name="relation_humble")
    private int relationHumble;

    @Column(name="relation_friends")
    private int relationFriends;

    @Column(name = "relation_region")
    private int relationRegion;

    @Column(name = "success_own_decision")
    private int successOwnDecision;

    @Column(name = "success_rich")
    private int successRich;

    @Column(name="success_recognize")
    private int successRecognize;

    @Column(name="success_admire")
    private int successAdmire;

    @Column(name = "success_leader")
    private int successLeader;

    @Column(name = "life_good")
    private int lifeGood;

    @Column(name = "life_job")
    private int lifeJob;

    @Column(name = "life_fun")
    private int lifeFun;

    @Column(name = "life_safe")
    private int lifeSafe;

    @Column(name = "life_givefun")
    private int lifeGivefun;

    @Column(name = "adventure_creative")
    private int adventureCreative;

    @Column(name = "adventure_idea")
    private int adventureIdea;

    @Column(name = "adventure_fun")
    private int adventureFun;

    @Column(name = "job_website")
    private int jobWebsite;

    @Column(name = "job_database")
    private int jobDatabase;

    @Column(name = "job_it_infrastructure")
    private int jobItInfrastructure;

    @Column(name = "job_data_science")
    private int jobDataScience;

    @Column(name = "job_games")
    private int jobGames;

    @Column(name = "job_finance")
    private int jobFinance;

    @Column(name = "job_utilities")
    private int jobUtilities;

    @Column(name = "job_programming_tools")
    private int jobProgrammingTools;

    @Column(name = "job_entertainment")
    private int jobEntertainment;

    @Column(name = "job_system_software")
    private int jobSystemSoftware;

    @Builder
    public SurveyRecord(Long surveyRecordId, int aboutmeDev, int aboutmeDevType, int aboutmeAge, int aboutmeGender, int aboutmeSalary, int aboutmeWork, int aboutmeMobile, int devHeadphone, int devEat, int devDrink, int devTeamSize, int devWorktime, int moralCctv, int moralRule, int moralHelp, int moralGovProtection, int moralManner, int moralEnvironment, int relationEqual, int relationUnderstand, int relationHumble, int relationFriends, int relationRegion, int successOwnDecision, int successRich, int successRecognize, int successAdmire, int successLeader, int lifeGood, int lifeJob, int lifeFun, int lifeSafe, int lifeGivefun, int adventureCreative, int adventureIdea, int adventureFun, int jobWebsite, int jobDatabase, int jobItInfrastructure, int jobDataScience, int jobGames, int jobFinance, int jobUtilities, int jobProgrammingTools, int jobEntertainment, int jobSystemSoftware) {
        this.surveyRecordId = surveyRecordId;
        this.aboutmeDev = aboutmeDev;
        this.aboutmeDevType = aboutmeDevType;
        this.aboutmeAge = aboutmeAge;
        this.aboutmeGender = aboutmeGender;
        this.aboutmeSalary = aboutmeSalary;
        this.aboutmeWork = aboutmeWork;
        this.aboutmeMobile = aboutmeMobile;
        this.devHeadphone = devHeadphone;
        this.devEat = devEat;
        this.devDrink = devDrink;
        this.devTeamSize = devTeamSize;
        this.devWorktime = devWorktime;
        this.moralCctv = moralCctv;
        this.moralRule = moralRule;
        this.moralHelp = moralHelp;
        this.moralGovProtection = moralGovProtection;
        this.moralManner = moralManner;
        this.moralEnvironment = moralEnvironment;
        this.relationEqual = relationEqual;
        this.relationUnderstand = relationUnderstand;
        this.relationHumble = relationHumble;
        this.relationFriends = relationFriends;
        this.relationRegion = relationRegion;
        this.successOwnDecision = successOwnDecision;
        this.successRich = successRich;
        this.successRecognize = successRecognize;
        this.successAdmire = successAdmire;
        this.successLeader = successLeader;
        this.lifeGood = lifeGood;
        this.lifeJob = lifeJob;
        this.lifeFun = lifeFun;
        this.lifeSafe = lifeSafe;
        this.lifeGivefun = lifeGivefun;
        this.adventureCreative = adventureCreative;
        this.adventureIdea = adventureIdea;
        this.adventureFun = adventureFun;
        this.jobWebsite = jobWebsite;
        this.jobDatabase = jobDatabase;
        this.jobItInfrastructure = jobItInfrastructure;
        this.jobDataScience = jobDataScience;
        this.jobGames = jobGames;
        this.jobFinance = jobFinance;
        this.jobUtilities = jobUtilities;
        this.jobProgrammingTools = jobProgrammingTools;
        this.jobEntertainment = jobEntertainment;
        this.jobSystemSoftware = jobSystemSoftware;
    }
}
