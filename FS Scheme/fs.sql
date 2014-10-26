/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     24.10.2014 12:09:49                          */
/*==============================================================*/


alter table "choreographer"
   drop constraint "FK_CHOREOGR_IS_ CHORE_PERSON";

alter table "citizenship"
   drop constraint FK_CITIZENS_CITIZENSH_COUNTRY;

alter table "citizenship"
   drop constraint FK_CITIZENS_CITIZENSH_PERSON;

alter table "coach"
   drop constraint FK_COACH_IS_COACH_PERSON;

alter table "competition"
   drop constraint FK_COMPETIT_COMPETITI_COMPETIT;

alter table "pair"
   drop constraint FK_PAIR_PARTNERS_SKATER;

alter table "pair"
   drop constraint FK_PAIR_PARTNERS2_SKATER;

alter table "period"
   drop constraint FK_PERIOD_PAIR_PERI_PAIR;

alter table "result"
   drop constraint FK_RESULT_PAIR_COMP_PAIR;

alter table "result"
   drop constraint FK_RESULT_RESULT_PR_SKATER_P;

alter table "result"
   drop constraint FK_RESULT_RESULT_PR_SKATER_P2;

alter table "result"
   drop constraint FK_RESULT_RESULT_PR_SKATER_P3;

alter table "result"
   drop constraint FK_RESULT_SKATER_CO_COMPETIT;

alter table "result"
   drop constraint FK_RESULT_SKATER_CO_SKATER;

alter table "skater"
   drop constraint FK_SKATER_IS_SKATER_PERSON;

alter table "skater_coach"
   drop constraint FK_SKATER_C_SKATER_CO_COACH;

alter table "skater_coach"
   drop constraint FK_SKATER_C_SKATER_CO_SKATER2;

alter table "skater_country"
   drop constraint FK_SKATER_C_SKATER_CO_COUNTRY;

alter table "skater_country"
   drop constraint FK_SKATER_C_SKATER_CO_SKATER;

alter table "skater_discipline"
   drop constraint FK_SKATER_D_DISCIPLIN_DISCIPLI;

alter table "skater_discipline"
   drop constraint FK_SKATER_D_DISCIPLIN_SKATER;

alter table "skater_programs"
   drop constraint FK_SKATER_P_CHOREOGRA_CHOREOGR;

alter table "skater_programs"
   drop constraint FK_SKATER_P_PAIR_PROG_PAIR;

alter table "skater_programs"
   drop constraint FK_SKATER_P_PROGRAM_S_PROGRAM;

alter table "skater_programs"
   drop constraint FK_SKATER_P_SKATER_PR_SKATER;

drop table "choreographer" cascade constraints;

drop index "citizenship_FK";

drop index "citizenship2_FK";

drop table "citizenship" cascade constraints;

drop table "coach" cascade constraints;

drop index "competition_type_relationship_";

drop table "competition" cascade constraints;

drop table "competition_type" cascade constraints;

drop table "country" cascade constraints;

drop table "discipline" cascade constraints;

drop index "partners_FK";

drop index "partners2_FK";

drop table "pair" cascade constraints;

drop index "pair_period_FK";

drop table "period" cascade constraints;

drop table "person" cascade constraints;

drop table "program" cascade constraints;

drop index "result_program3_FK";

drop index "result_program_FK";

drop index "result_program2_FK";

drop index "skater_competition_FK";

drop index "skater_competition2_FK";

drop table "result" cascade constraints;

drop table "skater" cascade constraints;

drop index "skater_coach_FK";

drop index "skater_coach2_FK";

drop table "skater_coach" cascade constraints;

drop index "skater_country_FK";

drop index "skater_country2_FK";

drop table "skater_country" cascade constraints;

drop index "discipline_FK";

drop index "discipline2_FK";

drop table "skater_discipline" cascade constraints;

drop index "program_skater_programs_FK";

drop index "skater_program_FK";

drop index "choreographer_program2_FK";

drop table "skater_programs" cascade constraints;

/*==============================================================*/
/* Table: "choreographer"                                       */
/*==============================================================*/
create table "choreographer" 
(
   "id_person"          INTEGER              not null,
   constraint PK_CHOREOGRAPHER primary key ("id_person")
);

/*==============================================================*/
/* Table: "citizenship"                                         */
/*==============================================================*/
create table "citizenship" 
(
   "short_name"         VARCHAR2(3)          not null,
   "id_person"          INTEGER              not null,
   constraint PK_CITIZENSHIP primary key ("short_name", "id_person")
);

/*==============================================================*/
/* Index: "citizenship2_FK"                                     */
/*==============================================================*/
create index "citizenship2_FK" on "citizenship" (
   "id_person" ASC
);

/*==============================================================*/
/* Index: "citizenship_FK"                                      */
/*==============================================================*/
create index "citizenship_FK" on "citizenship" (
   "short_name" ASC
);

/*==============================================================*/
/* Table: "coach"                                               */
/*==============================================================*/
create table "coach" 
(
   "id_person"          INTEGER              not null,
   constraint PK_COACH primary key ("id_person")
);

/*==============================================================*/
/* Table: "competition"                                         */
/*==============================================================*/
create table "competition" 
(
   "id_competition"     INTEGER              not null,
   "id_competition_type" INTEGER              not null,
   "name_competition"   VARCHAR2(30)         not null,
   "location"           VARCHAR2(30)         not null,
   "start_date"         DATE,
   "finish_date"        DATE,
   constraint PK_COMPETITION primary key ("id_competition")
);

/*==============================================================*/
/* Index: "competition_type_relationship_"                      */
/*==============================================================*/
create index "competition_type_relationship_" on "competition" (
   "id_competition_type" ASC
);

/*==============================================================*/
/* Table: "competition_type"                                    */
/*==============================================================*/
create table "competition_type" 
(
   "id_competition_type" INTEGER              not null,
   "name_competition_type" VARCHAR2(30)         not null,
   constraint PK_COMPETITION_TYPE primary key ("id_competition_type")
);

/*==============================================================*/
/* Table: "country"                                             */
/*==============================================================*/
create table "country" 
(
   "short_name"         VARCHAR2(3)          not null,
   "name"               VARCHAR2(30)         not null,
   constraint PK_COUNTRY primary key ("short_name")
);

/*==============================================================*/
/* Table: "discipline"                                          */
/*==============================================================*/
create table "discipline" 
(
   "id_discipline"      INTEGER              not null,
   "name"               VARCHAR2(30)         not null,
   constraint PK_DISCIPLINE primary key ("id_discipline")
);

/*==============================================================*/
/* Table: "pair"                                                */
/*==============================================================*/
create table "pair" 
(
   "id_pair"            INTEGER              not null,
   "id_lady"            INTEGER              not null,
   "id_man"             INTEGER              not null,
   "discipline"         VARCHAR2(30)         not null,
   constraint PK_PAIR primary key ("id_pair")
);

/*==============================================================*/
/* Index: "partners2_FK"                                        */
/*==============================================================*/
create index "partners2_FK" on "pair" (
   "id_man" ASC
);

/*==============================================================*/
/* Index: "partners_FK"                                         */
/*==============================================================*/
create index "partners_FK" on "pair" (
   "id_lady" ASC
);

/*==============================================================*/
/* Table: "period"                                              */
/*==============================================================*/
create table "period" 
(
   "id_event"           INTEGER              not null,
   "id_pair"            INTEGER              not null,
   "start_season"       INTEGER,
   "finish_season"      INTEGER,
   constraint PK_PERIOD primary key ("id_event")
);

/*==============================================================*/
/* Index: "pair_period_FK"                                      */
/*==============================================================*/
create index "pair_period_FK" on "period" (
   "id_pair" ASC
);

/*==============================================================*/
/* Table: "person"                                              */
/*==============================================================*/
create table "person" 
(
   "id_person"          INTEGER              not null,
   "name"               VARCHAR2(30)         not null,
   "sex"                VARCHAR2(1)          not null,
   "birthday"           DATE,
   "info"               CLOB,
   "is_reigning_skater" SMALLINT,
   "is_reigning_coach"  SMALLINT,
   "is_reigning_choreographer" SMALLINT,
   constraint PK_PERSON primary key ("id_person")
);

/*==============================================================*/
/* Table: "program"                                             */
/*==============================================================*/
create table "program" 
(
   "id_program"         INTEGER              not null,
   "name_program"       VARCHAR2(100)        not null,
   constraint PK_PROGRAM primary key ("id_program")
);

/*==============================================================*/
/* Table: "result"                                              */
/*==============================================================*/
create table "result" 
(
   "id_result"          INTEGER              not null,
   "id_competition"     INTEGER              not null,
   "id_single_or_pair"  INTEGER              not null,
   "discipline"         VARCHAR2(30)         not null,
   "country"            VARCHAR2(30)         not null,
   "sp_score"           NUMBER(3,2),
   "sp_place"           INTEGER,
   "sp_video"           VARCHAR2(100),
   "sp_program"         INTEGER,
   "fs_score"           NUMBER(3,2),
   "fs_place"           INTEGER,
   "fs_video"           VARCHAR2(100),
   "fs_program"         INTEGER,
   "total_place"        INTEGER,
   "photo"              VARCHAR2(2000),
   "cd_score"           NUMBER(3,2),
   "cd_place"           INTEGER,
   "cd_video"           VARCHAR2(100),
   "cd_program"         INTEGER,
   constraint PK_RESULT primary key ("id_result")
);

/*==============================================================*/
/* Index: "skater_competition2_FK"                              */
/*==============================================================*/
create index "skater_competition2_FK" on "result" (
   "id_single_or_pair" ASC
);

/*==============================================================*/
/* Index: "skater_competition_FK"                               */
/*==============================================================*/
create index "skater_competition_FK" on "result" (
   "id_competition" ASC
);

/*==============================================================*/
/* Index: "result_program2_FK"                                  */
/*==============================================================*/
create index "result_program2_FK" on "result" (
   "sp_program" ASC
);

/*==============================================================*/
/* Index: "result_program_FK"                                   */
/*==============================================================*/
create index "result_program_FK" on "result" (
   "fs_program" ASC
);

/*==============================================================*/
/* Index: "result_program3_FK"                                  */
/*==============================================================*/
create index "result_program3_FK" on "result" (
   "cd_program" ASC
);

/*==============================================================*/
/* Table: "skater"                                              */
/*==============================================================*/
create table "skater" 
(
   "id_person"          INTEGER              not null,
   constraint PK_SKATER primary key ("id_person")
);

/*==============================================================*/
/* Table: "skater_coach"                                        */
/*==============================================================*/
create table "skater_coach" 
(
   "id_event"           INTEGER              not null,
   "id_coach"           INTEGER              not null,
   "id_skater"          INTEGER              not null,
   "start_season"       INTEGER,
   "finish_season"      INTEGER,
   constraint PK_SKATER_COACH primary key ("id_event")
);

/*==============================================================*/
/* Index: "skater_coach2_FK"                                    */
/*==============================================================*/
create index "skater_coach2_FK" on "skater_coach" (
   "id_skater" ASC
);

/*==============================================================*/
/* Index: "skater_coach_FK"                                     */
/*==============================================================*/
create index "skater_coach_FK" on "skater_coach" (
   "id_coach" ASC
);

/*==============================================================*/
/* Table: "skater_country"                                      */
/*==============================================================*/
create table "skater_country" 
(
   "id_event"           INTEGER              not null,
   "id_person"          INTEGER              not null,
   "short_name"         VARCHAR2(3)          not null,
   "start_season"       INTEGER,
   "finish_season"      INTEGER,
   constraint PK_SKATER_COUNTRY primary key ("id_event")
);

/*==============================================================*/
/* Index: "skater_country2_FK"                                  */
/*==============================================================*/
create index "skater_country2_FK" on "skater_country" (
   "id_person" ASC
);

/*==============================================================*/
/* Index: "skater_country_FK"                                   */
/*==============================================================*/
create index "skater_country_FK" on "skater_country" (
   "short_name" ASC
);

/*==============================================================*/
/* Table: "skater_discipline"                                   */
/*==============================================================*/
create table "skater_discipline" 
(
   "id_event"           INTEGER              not null,
   "id_person"          INTEGER              not null,
   "id_discipline"      INTEGER              not null,
   "start_season"       INTEGER,
   "finish_season"      INTEGER,
   constraint PK_SKATER_DISCIPLINE primary key ("id_event")
);

/*==============================================================*/
/* Index: "discipline2_FK"                                      */
/*==============================================================*/
create index "discipline2_FK" on "skater_discipline" (
   "id_person" ASC
);

/*==============================================================*/
/* Index: "discipline_FK"                                       */
/*==============================================================*/
create index "discipline_FK" on "skater_discipline" (
   "id_discipline" ASC
);

/*==============================================================*/
/* Table: "skater_programs"                                     */
/*==============================================================*/
create table "skater_programs" 
(
   "id_program_single_or_pair_chor" INTEGER              default NULL not null,
   "id_program"         INTEGER              not null,
   "id_single_or_pair"  INTEGER              not null,
   "id_choreographer"   INTEGER              not null,
   "discipline"         VARCHAR2(30)         not null,
   "season"             INTEGER,
   "type"               VARCHAR2(2),
   constraint PK_SKATER_PROGRAMS primary key ("id_program_single_or_pair_chor")
);

/*==============================================================*/
/* Index: "choreographer_program2_FK"                           */
/*==============================================================*/
create index "choreographer_program2_FK" on "skater_programs" (
   "id_choreographer" ASC
);

/*==============================================================*/
/* Index: "skater_program_FK"                                   */
/*==============================================================*/
create index "skater_program_FK" on "skater_programs" (
   "id_single_or_pair" ASC
);

/*==============================================================*/
/* Index: "program_skater_programs_FK"                          */
/*==============================================================*/
create index "program_skater_programs_FK" on "skater_programs" (
   "id_program" ASC
);

alter table "choreographer"
   add constraint "FK_CHOREOGR_IS_ CHORE_PERSON" foreign key ("id_person")
      references "person" ("id_person");

alter table "citizenship"
   add constraint FK_CITIZENS_CITIZENSH_COUNTRY foreign key ("short_name")
      references "country" ("short_name");

alter table "citizenship"
   add constraint FK_CITIZENS_CITIZENSH_PERSON foreign key ("id_person")
      references "person" ("id_person");

alter table "coach"
   add constraint FK_COACH_IS_COACH_PERSON foreign key ("id_person")
      references "person" ("id_person");

alter table "competition"
   add constraint FK_COMPETIT_COMPETITI_COMPETIT foreign key ("id_competition_type")
      references "competition_type" ("id_competition_type");

alter table "pair"
   add constraint FK_PAIR_PARTNERS_SKATER foreign key ("id_lady")
      references "skater" ("id_person");

alter table "pair"
   add constraint FK_PAIR_PARTNERS2_SKATER foreign key ("id_man")
      references "skater" ("id_person");

alter table "period"
   add constraint FK_PERIOD_PAIR_PERI_PAIR foreign key ("id_pair")
      references "pair" ("id_pair");

alter table "result"
   add constraint FK_RESULT_PAIR_COMP_PAIR foreign key ("id_single_or_pair")
      references "pair" ("id_pair");

alter table "result"
   add constraint FK_RESULT_RESULT_PR_SKATER_P foreign key ("fs_program")
      references "skater_programs" ("id_program_single_or_pair_chor");

alter table "result"
   add constraint FK_RESULT_RESULT_PR_SKATER_P2 foreign key ("sp_program")
      references "skater_programs" ("id_program_single_or_pair_chor");

alter table "result"
   add constraint FK_RESULT_RESULT_PR_SKATER_P3 foreign key ("cd_program")
      references "skater_programs" ("id_program_single_or_pair_chor");

alter table "result"
   add constraint FK_RESULT_SKATER_CO_COMPETIT foreign key ("id_competition")
      references "competition" ("id_competition");

alter table "result"
   add constraint FK_RESULT_SKATER_CO_SKATER foreign key ("id_single_or_pair")
      references "skater" ("id_person");

alter table "skater"
   add constraint FK_SKATER_IS_SKATER_PERSON foreign key ("id_person")
      references "person" ("id_person");

alter table "skater_coach"
   add constraint FK_SKATER_C_SKATER_CO_COACH foreign key ("id_coach")
      references "coach" ("id_person");

alter table "skater_coach"
   add constraint FK_SKATER_C_SKATER_CO_SKATER2 foreign key ("id_skater")
      references "skater" ("id_person");

alter table "skater_country"
   add constraint FK_SKATER_C_SKATER_CO_COUNTRY foreign key ("short_name")
      references "country" ("short_name");

alter table "skater_country"
   add constraint FK_SKATER_C_SKATER_CO_SKATER foreign key ("id_person")
      references "skater" ("id_person");

alter table "skater_discipline"
   add constraint FK_SKATER_D_DISCIPLIN_DISCIPLI foreign key ("id_discipline")
      references "discipline" ("id_discipline");

alter table "skater_discipline"
   add constraint FK_SKATER_D_DISCIPLIN_SKATER foreign key ("id_person")
      references "skater" ("id_person");

alter table "skater_programs"
   add constraint FK_SKATER_P_CHOREOGRA_CHOREOGR foreign key ("id_choreographer")
      references "choreographer" ("id_person");

alter table "skater_programs"
   add constraint FK_SKATER_P_PAIR_PROG_PAIR foreign key ("id_single_or_pair")
      references "pair" ("id_pair");

alter table "skater_programs"
   add constraint FK_SKATER_P_PROGRAM_S_PROGRAM foreign key ("id_program")
      references "program" ("id_program");

alter table "skater_programs"
   add constraint FK_SKATER_P_SKATER_PR_SKATER foreign key ("id_single_or_pair")
      references "skater" ("id_person");

