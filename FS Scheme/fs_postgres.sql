/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     25.10.2014 10:58:55                          */
/*==============================================================*/


drop table choreographer;

drop index citizenship_FK;

drop index citizenship2_FK;

drop table citizenship;

drop table coach;

drop index competition_type_relationship_;

drop table competition;

drop table competition_type;

drop table country;

drop table discipline;

drop index partners_FK;

drop index partners2_FK;

drop table pair;

drop index pair_period_FK;

drop table period;

drop table person;

drop table program;

drop index result_program3_FK;

drop index result_program_FK;

drop index result_program2_FK;

drop index skater_competition_FK;

drop index skater_competition2_FK;

drop table result;

drop table skater;

drop index skater_coach_FK;

drop index skater_coach2_FK;

drop table skater_coach;

drop index skater_country_FK;

drop index skater_country2_FK;

drop table skater_country;

drop index discipline_FK;

drop index discipline2_FK;

drop table skater_discipline;

drop index program_skater_programs_FK;

drop index skater_program_FK;

drop index choreographer_program2_FK;

drop table skater_programs;

/*==============================================================*/
/* Table: choreographer                                         */
/*==============================================================*/
create table choreographer (
   id_person            INT4                 not null,
   constraint PK_CHOREOGRAPHER primary key (id_person)
);

/*==============================================================*/
/* Table: citizenship                                           */
/*==============================================================*/
create table citizenship (
   short_name           VARCHAR(3)           not null,
   id_person            INT4                 not null,
   constraint PK_CITIZENSHIP primary key (short_name, id_person)
);

/*==============================================================*/
/* Index: citizenship2_FK                                       */
/*==============================================================*/
create  index citizenship2_FK on citizenship (
id_person
);

/*==============================================================*/
/* Index: citizenship_FK                                        */
/*==============================================================*/
create  index citizenship_FK on citizenship (
short_name
);

/*==============================================================*/
/* Table: coach                                                 */
/*==============================================================*/
create table coach (
   id_person            INT4                 not null,
   constraint PK_COACH primary key (id_person)
);

/*==============================================================*/
/* Table: competition                                           */
/*==============================================================*/
create table competition (
   id_competition       INT4                 not null,
   id_competition_type  INT4                 not null,
   name_competition     VARCHAR(30)          not null,
   location             VARCHAR(30)          not null,
   start_date           DATE                 null,
   finish_date          DATE                 null,
   constraint PK_COMPETITION primary key (id_competition)
);

/*==============================================================*/
/* Index: competition_type_relationship_                        */
/*==============================================================*/
create  index competition_type_relationship_ on competition (
id_competition_type
);

/*==============================================================*/
/* Table: competition_type                                      */
/*==============================================================*/
create table competition_type (
   id_competition_type  INT4                 not null,
   name_competition_type VARCHAR(30)          not null,
   constraint PK_COMPETITION_TYPE primary key (id_competition_type)
);

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
create table country (
   short_name           VARCHAR(3)           not null,
   name                 VARCHAR(30)          not null,
   constraint PK_COUNTRY primary key (short_name)
);

/*==============================================================*/
/* Table: discipline                                            */
/*==============================================================*/
create table discipline (
   id_discipline        INT4                 not null,
   name                 VARCHAR(30)          not null,
   constraint PK_DISCIPLINE primary key (id_discipline)
);

/*==============================================================*/
/* Table: pair                                                  */
/*==============================================================*/
create table pair (
   id_pair              INT4                 not null,
   id_lady              INT4                 not null,
   id_man               INT4                 not null,
   discipline           VARCHAR(30)          not null,
   constraint PK_PAIR primary key (id_pair)
);

/*==============================================================*/
/* Index: partners2_FK                                          */
/*==============================================================*/
create  index partners2_FK on pair (
id_man
);

/*==============================================================*/
/* Index: partners_FK                                           */
/*==============================================================*/
create  index partners_FK on pair (
id_lady
);

/*==============================================================*/
/* Table: period                                                */
/*==============================================================*/
create table period (
   id_event             INT4                 not null,
   id_pair              INT4                 not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_PERIOD primary key (id_event)
);

/*==============================================================*/
/* Index: pair_period_FK                                        */
/*==============================================================*/
create  index pair_period_FK on period (
id_pair
);

/*==============================================================*/
/* Table: person                                                */
/*==============================================================*/
create table person (
   id_person            INT4                 not null,
   name                 VARCHAR(30)          not null,
   sex                  VARCHAR(1)           not null,
   birthday             DATE                 null,
   info                 TEXT                 null,
   is_reigning_skater   INT2                 null,
   is_reigning_coach    INT2                 null,
   is_reigning_choreographer INT2                 null,
   constraint PK_PERSON primary key (id_person)
);

/*==============================================================*/
/* Table: program                                               */
/*==============================================================*/
create table program (
   id_program           INT4                 not null,
   name_program         VARCHAR(100)         not null,
   constraint PK_PROGRAM primary key (id_program)
);

/*==============================================================*/
/* Table: result                                                */
/*==============================================================*/
create table result (
   id_result            INT4                 not null,
   id_competition       INT4                 not null,
   id_single_or_pair    INT4                 not null,
   discipline           VARCHAR(30)          not null,
   country              VARCHAR(30)          not null,
   sp_score             NUMERIC(3,2)         null,
   sp_place             INT4                 null,
   sp_video             VARCHAR(100)         null,
   sp_program           INT4                 null,
   fs_score             NUMERIC(3,2)         null,
   fs_place             INT4                 null,
   fs_video             VARCHAR(100)         null,
   fs_program           INT4                 null,
   total_place          INT4                 null,
   photo                VARCHAR(2000)        null,
   cd_score             NUMERIC(3,2)         null,
   cd_place             INT4                 null,
   cd_video             VARCHAR(100)         null,
   cd_program           INT4                 null,
   constraint PK_RESULT primary key (id_result)
);

/*==============================================================*/
/* Index: skater_competition2_FK                                */
/*==============================================================*/
create  index skater_competition2_FK on result (
id_single_or_pair
);

/*==============================================================*/
/* Index: skater_competition_FK                                 */
/*==============================================================*/
create  index skater_competition_FK on result (
id_competition
);

/*==============================================================*/
/* Index: result_program2_FK                                    */
/*==============================================================*/
create  index result_program2_FK on result (
sp_program
);

/*==============================================================*/
/* Index: result_program_FK                                     */
/*==============================================================*/
create  index result_program_FK on result (
fs_program
);

/*==============================================================*/
/* Index: result_program3_FK                                    */
/*==============================================================*/
create  index result_program3_FK on result (
cd_program
);

/*==============================================================*/
/* Table: skater                                                */
/*==============================================================*/
create table skater (
   id_person            INT4                 not null,
   constraint PK_SKATER primary key (id_person)
);

/*==============================================================*/
/* Table: skater_coach                                          */
/*==============================================================*/
create table skater_coach (
   id_event             INT4                 not null,
   id_coach             INT4                 not null,
   id_skater            INT4                 not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_COACH primary key (id_event)
);

/*==============================================================*/
/* Index: skater_coach2_FK                                      */
/*==============================================================*/
create  index skater_coach2_FK on skater_coach (
id_skater
);

/*==============================================================*/
/* Index: skater_coach_FK                                       */
/*==============================================================*/
create  index skater_coach_FK on skater_coach (
id_coach
);

/*==============================================================*/
/* Table: skater_country                                        */
/*==============================================================*/
create table skater_country (
   id_event             INT4                 not null,
   id_person            INT4                 not null,
   short_name           VARCHAR(3)           not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_COUNTRY primary key (id_event)
);

/*==============================================================*/
/* Index: skater_country2_FK                                    */
/*==============================================================*/
create  index skater_country2_FK on skater_country (
id_person
);

/*==============================================================*/
/* Index: skater_country_FK                                     */
/*==============================================================*/
create  index skater_country_FK on skater_country (
short_name
);

/*==============================================================*/
/* Table: skater_discipline                                     */
/*==============================================================*/
create table skater_discipline (
   id_event             INT4                 not null,
   id_person            INT4                 not null,
   id_discipline        INT4                 not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_DISCIPLINE primary key (id_event)
);

/*==============================================================*/
/* Index: discipline2_FK                                        */
/*==============================================================*/
create  index discipline2_FK on skater_discipline (
id_person
);

/*==============================================================*/
/* Index: discipline_FK                                         */
/*==============================================================*/
create  index discipline_FK on skater_discipline (
id_discipline
);

/*==============================================================*/
/* Table: skater_programs                                       */
/*==============================================================*/
create table skater_programs (
   id_program_single_or_pair_chor INT4                 not null default NULL,
   id_program           INT4                 not null,
   id_single_or_pair    INT4                 not null,
   id_choreographer     INT4                 not null,
   discipline           VARCHAR(30)          not null,
   season               INT4                 null,
   type                 VARCHAR(2)           null,
   constraint PK_SKATER_PROGRAMS primary key (id_program_single_or_pair_chor)
);

/*==============================================================*/
/* Index: choreographer_program2_FK                             */
/*==============================================================*/
create  index choreographer_program2_FK on skater_programs (
id_choreographer
);

/*==============================================================*/
/* Index: skater_program_FK                                     */
/*==============================================================*/
create  index skater_program_FK on skater_programs (
id_single_or_pair
);

/*==============================================================*/
/* Index: program_skater_programs_FK                            */
/*==============================================================*/
create  index program_skater_programs_FK on skater_programs (
id_program
);

alter table choreographer
   add constraint "FK_CHOREOGR_IS_ CHORE_PERSON" foreign key (id_person)
      references person (id_person)
      on delete restrict on update restrict;

alter table citizenship
   add constraint FK_CITIZENS_CITIZENSH_COUNTRY foreign key (short_name)
      references country (short_name)
      on delete restrict on update restrict;

alter table citizenship
   add constraint FK_CITIZENS_CITIZENSH_PERSON foreign key (id_person)
      references person (id_person)
      on delete restrict on update restrict;

alter table coach
   add constraint FK_COACH_IS_COACH_PERSON foreign key (id_person)
      references person (id_person)
      on delete restrict on update restrict;

alter table competition
   add constraint FK_COMPETIT_COMPETITI_COMPETIT foreign key (id_competition_type)
      references competition_type (id_competition_type)
      on delete restrict on update restrict;

alter table pair
   add constraint FK_PAIR_PARTNERS_SKATER foreign key (id_lady)
      references skater (id_person)
      on delete restrict on update restrict;

alter table pair
   add constraint FK_PAIR_PARTNERS2_SKATER foreign key (id_man)
      references skater (id_person)
      on delete restrict on update restrict;

alter table period
   add constraint FK_PERIOD_PAIR_PERI_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_PAIR_COMP_PAIR foreign key (id_single_or_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P foreign key (fs_program)
      references skater_programs (id_program_single_or_pair_chor)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P2 foreign key (sp_program)
      references skater_programs (id_program_single_or_pair_chor)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P3 foreign key (cd_program)
      references skater_programs (id_program_single_or_pair_chor)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_SKATER_CO_COMPETIT foreign key (id_competition)
      references competition (id_competition)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_SKATER_CO_SKATER foreign key (id_single_or_pair)
      references skater (id_person)
      on delete restrict on update restrict;

alter table skater
   add constraint FK_SKATER_IS_SKATER_PERSON foreign key (id_person)
      references person (id_person)
      on delete restrict on update restrict;

alter table skater_coach
   add constraint FK_SKATER_C_SKATER_CO_COACH foreign key (id_coach)
      references coach (id_person)
      on delete restrict on update restrict;

alter table skater_coach
   add constraint FK_SKATER_C_SKATER_CO_SKATER2 foreign key (id_skater)
      references skater (id_person)
      on delete restrict on update restrict;

alter table skater_country
   add constraint FK_SKATER_C_SKATER_CO_COUNTRY foreign key (short_name)
      references country (short_name)
      on delete restrict on update restrict;

alter table skater_country
   add constraint FK_SKATER_C_SKATER_CO_SKATER foreign key (id_person)
      references skater (id_person)
      on delete restrict on update restrict;

alter table skater_discipline
   add constraint FK_SKATER_D_DISCIPLIN_DISCIPLI foreign key (id_discipline)
      references discipline (id_discipline)
      on delete restrict on update restrict;

alter table skater_discipline
   add constraint FK_SKATER_D_DISCIPLIN_SKATER foreign key (id_person)
      references skater (id_person)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_CHOREOGRA_CHOREOGR foreign key (id_choreographer)
      references choreographer (id_person)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_PAIR_PROG_PAIR foreign key (id_single_or_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_PROGRAM_S_PROGRAM foreign key (id_program)
      references program (id_program)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_SKATER_PR_SKATER foreign key (id_single_or_pair)
      references skater (id_person)
      on delete restrict on update restrict;

