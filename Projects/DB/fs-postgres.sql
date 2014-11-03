/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     03.11.2014 11:49:56                          */
/*==============================================================*/


drop index choreographer_PK;

drop table choreographer;

drop index citizenship_FK;

drop index citizenship2_FK;

drop index citizenship_PK;

drop table citizenship;

drop index coach_PK;

drop table coach;

drop index competition_type_relationship_F;

drop index competition_PK;

drop table competition;

drop index competition_type_PK;

drop table competition_type;

drop index country_PK;

drop table country;

drop index discipline_PK;

drop table discipline;

drop index partners_FK;

drop index partners2_FK;

drop index pair_PK;

drop table pair;

drop index pair_period_FK;

drop index period_PK;

drop table period;

drop index person_PK;

drop table person;

drop index program_PK;

drop table program;

drop index result_program3_FK;

drop index result_program_FK;

drop index result_program2_FK;

drop index pair_competition_FK;

drop index skater_competition_FK;

drop index skater_competition2_FK;

drop index result_PK;

drop table result;

drop index skater_PK;

drop table skater;

drop index pair_coach_FK;

drop index skater_coach_FK;

drop index skater_coach2_FK;

drop index skater_coach_PK;

drop table skater_coach;

drop index pair_country_FK;

drop index skater_country_FK;

drop index skater_country2_FK;

drop index skater_country_PK;

drop table skater_country;

drop index discipline_FK;

drop index discipline2_FK;

drop index skater_discipline_PK;

drop table skater_discipline;

drop index program_skater_programs_FK;

drop index pair_program_FK;

drop index skater_program_FK;

drop index choreographer_program2_FK;

drop index skater_programs_PK;

drop table skater_programs;

/*==============================================================*/
/* Table: choreographer                                         */
/*==============================================================*/
create table choreographer (
   id_choreographer     VARCHAR(32)          not null,
   constraint PK_CHOREOGRAPHER primary key (id_choreographer)
);

/*==============================================================*/
/* Index: choreographer_PK                                      */
/*==============================================================*/
create unique index choreographer_PK on choreographer (
id_choreographer
);

/*==============================================================*/
/* Table: citizenship                                           */
/*==============================================================*/
create table citizenship (
   short_name           VARCHAR(3)           not null,
   id_person            VARCHAR(32)          not null,
   constraint PK_CITIZENSHIP primary key (short_name, id_person)
);

/*==============================================================*/
/* Index: citizenship_PK                                        */
/*==============================================================*/
create unique index citizenship_PK on citizenship (
short_name,
id_person
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
   id_coach             VARCHAR(32)          not null,
   constraint PK_COACH primary key (id_coach)
);

/*==============================================================*/
/* Index: coach_PK                                              */
/*==============================================================*/
create unique index coach_PK on coach (
id_coach
);

/*==============================================================*/
/* Table: competition                                           */
/*==============================================================*/
create table competition (
   id_competition       VARCHAR(32)          not null,
   id_competition_type  VARCHAR(32)          not null,
   name_competition     VARCHAR(32)          not null,
   location             VARCHAR(32)          not null,
   start_date           DATE                 null,
   finish_date          DATE                 null,
   constraint PK_COMPETITION primary key (id_competition)
);

/*==============================================================*/
/* Index: competition_PK                                        */
/*==============================================================*/
create unique index competition_PK on competition (
id_competition
);

/*==============================================================*/
/* Index: competition_type_relationship_F                       */
/*==============================================================*/
create  index competition_type_relationship_F on competition (
id_competition_type
);

/*==============================================================*/
/* Table: competition_type                                      */
/*==============================================================*/
create table competition_type (
   id_competition_type  VARCHAR(32)          not null,
   name_competition_type VARCHAR(32)          not null,
   constraint PK_COMPETITION_TYPE primary key (id_competition_type)
);

/*==============================================================*/
/* Index: competition_type_PK                                   */
/*==============================================================*/
create unique index competition_type_PK on competition_type (
id_competition_type
);

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
create table country (
   short_name           VARCHAR(3)           not null,
   name                 VARCHAR(32)          not null,
   constraint PK_COUNTRY primary key (short_name)
);

/*==============================================================*/
/* Index: country_PK                                            */
/*==============================================================*/
create unique index country_PK on country (
short_name
);

/*==============================================================*/
/* Table: discipline                                            */
/*==============================================================*/
create table discipline (
   id_discipline        VARCHAR(32)          not null,
   name                 VARCHAR(30)          not null,
   constraint PK_DISCIPLINE primary key (id_discipline)
);

/*==============================================================*/
/* Index: discipline_PK                                         */
/*==============================================================*/
create unique index discipline_PK on discipline (
id_discipline
);

/*==============================================================*/
/* Table: pair                                                  */
/*==============================================================*/
create table pair (
   id_pair              VARCHAR(32)          not null,
   id_lady              VARCHAR(32)          not null,
   id_man               VARCHAR(32)          not null,
   discipline           VARCHAR(32)          not null,
   constraint PK_PAIR primary key (id_pair)
);

/*==============================================================*/
/* Index: pair_PK                                               */
/*==============================================================*/
create unique index pair_PK on pair (
id_pair
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
   id_event             VARCHAR(32)          not null,
   id_pair              VARCHAR(32)          not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_PERIOD primary key (id_event)
);

/*==============================================================*/
/* Index: period_PK                                             */
/*==============================================================*/
create unique index period_PK on period (
id_event
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
   id_person            VARCHAR(32)          not null,
   name                 VARCHAR(32)          not null,
   sex                  VARCHAR(1)           null
      constraint CKC_SEX_PERSON check (sex is null or (sex in ('f','m'))),
   birthday             DATE                 null,
   info                 TEXT                 null,
   is_reigning_skater   BOOL                 null,
   is_reigning_coach    BOOL                 null,
   is_reigning_choreographer BOOL                 null,
   constraint PK_PERSON primary key (id_person)
);

/*==============================================================*/
/* Index: person_PK                                             */
/*==============================================================*/
create unique index person_PK on person (
id_person
);

/*==============================================================*/
/* Table: program                                               */
/*==============================================================*/
create table program (
   id_program           VARCHAR(32)          not null,
   name_program         VARCHAR(100)         not null,
   constraint PK_PROGRAM primary key (id_program)
);

/*==============================================================*/
/* Index: program_PK                                            */
/*==============================================================*/
create unique index program_PK on program (
id_program
);

/*==============================================================*/
/* Table: result                                                */
/*==============================================================*/
create table result (
   id_result            VARCHAR(32)          not null,
   id_competition       VARCHAR(32)          not null,
   id_single            VARCHAR(32)          null,
   id_pair              VARCHAR(32)          null,
   discipline           VARCHAR(32)          not null,
   country              VARCHAR(32)          not null,
   cd_score             DECIMAL(5,2)         null,
   cd_place             INT4                 null,
   cd_video             VARCHAR(100)         null,
   cd_program           VARCHAR(32)          null,
   sp_score             DECIMAL(5,2)         null,
   sp_place             INT4                 null,
   sp_video             VARCHAR(100)         null,
   sp_program           VARCHAR(32)          null,
   fs_score             DECIMAL(5,2)         null,
   fs_place             INT4                 null,
   fs_video             VARCHAR(100)         null,
   fs_program           VARCHAR(32)          null,
   total_place          INT4                 null,
   total_score          DECIMAL(5,2)         null,
   photo                VARCHAR(2000)        null,
   constraint PK_RESULT primary key (id_result)
);

/*==============================================================*/
/* Index: result_PK                                             */
/*==============================================================*/
create unique index result_PK on result (
id_result
);

/*==============================================================*/
/* Index: skater_competition2_FK                                */
/*==============================================================*/
create  index skater_competition2_FK on result (
id_single
);

/*==============================================================*/
/* Index: skater_competition_FK                                 */
/*==============================================================*/
create  index skater_competition_FK on result (
id_competition
);

/*==============================================================*/
/* Index: pair_competition_FK                                   */
/*==============================================================*/
create  index pair_competition_FK on result (
id_pair
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
   id_skater            VARCHAR(32)          not null,
   constraint PK_SKATER primary key (id_skater)
);

/*==============================================================*/
/* Index: skater_PK                                             */
/*==============================================================*/
create unique index skater_PK on skater (
id_skater
);

/*==============================================================*/
/* Table: skater_coach                                          */
/*==============================================================*/
create table skater_coach (
   id_event             VARCHAR(32)          not null,
   id_coach             VARCHAR(32)          not null,
   id_single            VARCHAR(32)          null,
   id_pair              VARCHAR(32)          null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_COACH primary key (id_event)
);

/*==============================================================*/
/* Index: skater_coach_PK                                       */
/*==============================================================*/
create unique index skater_coach_PK on skater_coach (
id_event
);

/*==============================================================*/
/* Index: skater_coach2_FK                                      */
/*==============================================================*/
create  index skater_coach2_FK on skater_coach (
id_single
);

/*==============================================================*/
/* Index: skater_coach_FK                                       */
/*==============================================================*/
create  index skater_coach_FK on skater_coach (
id_coach
);

/*==============================================================*/
/* Index: pair_coach_FK                                         */
/*==============================================================*/
create  index pair_coach_FK on skater_coach (
id_pair
);

/*==============================================================*/
/* Table: skater_country                                        */
/*==============================================================*/
create table skater_country (
   id_event             VARCHAR(32)          not null,
   id_single            VARCHAR(32)          null,
   id_pair              VARCHAR(32)          null,
   short_name           VARCHAR(3)           not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_COUNTRY primary key (id_event)
);

/*==============================================================*/
/* Index: skater_country_PK                                     */
/*==============================================================*/
create unique index skater_country_PK on skater_country (
id_event
);

/*==============================================================*/
/* Index: skater_country2_FK                                    */
/*==============================================================*/
create  index skater_country2_FK on skater_country (
id_single
);

/*==============================================================*/
/* Index: skater_country_FK                                     */
/*==============================================================*/
create  index skater_country_FK on skater_country (
short_name
);

/*==============================================================*/
/* Index: pair_country_FK                                       */
/*==============================================================*/
create  index pair_country_FK on skater_country (
id_pair
);

/*==============================================================*/
/* Table: skater_discipline                                     */
/*==============================================================*/
create table skater_discipline (
   id_event             VARCHAR(32)          not null,
   id_skater            VARCHAR(32)          not null,
   id_discipline        VARCHAR(32)          not null,
   start_season         INT4                 null,
   finish_season        INT4                 null,
   constraint PK_SKATER_DISCIPLINE primary key (id_event)
);

/*==============================================================*/
/* Index: skater_discipline_PK                                  */
/*==============================================================*/
create unique index skater_discipline_PK on skater_discipline (
id_event
);

/*==============================================================*/
/* Index: discipline2_FK                                        */
/*==============================================================*/
create  index discipline2_FK on skater_discipline (
id_skater
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
   id_program_single_or_pair_chore VARCHAR(32)          not null,
   id_program           VARCHAR(32)          not null,
   id_single            VARCHAR(32)          null,
   id_pair              VARCHAR(32)          null,
   id_choreographer     VARCHAR(32)          not null,
   discipline           VARCHAR(32)          null,
   season               INT4                 null,
   type                 VARCHAR(2)           null,
   constraint PK_SKATER_PROGRAMS primary key (id_program_single_or_pair_chore)
);

/*==============================================================*/
/* Index: skater_programs_PK                                    */
/*==============================================================*/
create unique index skater_programs_PK on skater_programs (
id_program_single_or_pair_chore
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
id_single
);

/*==============================================================*/
/* Index: pair_program_FK                                       */
/*==============================================================*/
create  index pair_program_FK on skater_programs (
id_pair
);

/*==============================================================*/
/* Index: program_skater_programs_FK                            */
/*==============================================================*/
create  index program_skater_programs_FK on skater_programs (
id_program
);

alter table choreographer
   add constraint "FK_CHOREOGR_IS_ CHORE_PERSON" foreign key (id_choreographer)
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
   add constraint FK_COACH_IS_COACH_PERSON foreign key (id_coach)
      references person (id_person)
      on delete restrict on update restrict;

alter table competition
   add constraint FK_COMPETIT_COMPETITI_COMPETIT foreign key (id_competition_type)
      references competition_type (id_competition_type)
      on delete restrict on update restrict;

alter table pair
   add constraint FK_PAIR_PARTNERS_SKATER foreign key (id_lady)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table pair
   add constraint FK_PAIR_PARTNERS2_SKATER foreign key (id_man)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table period
   add constraint FK_PERIOD_PAIR_PERI_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_PAIR_COMP_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P3 foreign key (fs_program)
      references skater_programs (id_program_single_or_pair_chore)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P2 foreign key (sp_program)
      references skater_programs (id_program_single_or_pair_chore)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_RESULT_PR_SKATER_P foreign key (cd_program)
      references skater_programs (id_program_single_or_pair_chore)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_SKATER_CO_COMPETIT foreign key (id_competition)
      references competition (id_competition)
      on delete restrict on update restrict;

alter table result
   add constraint FK_RESULT_SKATER_CO_SKATER foreign key (id_single)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table skater
   add constraint FK_SKATER_IS_SKATER_PERSON foreign key (id_skater)
      references person (id_person)
      on delete restrict on update restrict;

alter table skater_coach
   add constraint FK_SKATER_C_PAIR_COAC_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table skater_coach
   add constraint FK_SKATER_C_SKATER_CO_COACH foreign key (id_coach)
      references coach (id_coach)
      on delete restrict on update restrict;

alter table skater_coach
   add constraint FK_SKATER_C_SKATER_CO_SKATER foreign key (id_single)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table skater_country
   add constraint FK_SKATER_C_PAIR_COUN_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table skater_country
   add constraint FK_SKATER_C_SKATER_CO_COUNTRY foreign key (short_name)
      references country (short_name)
      on delete restrict on update restrict;

alter table skater_country
   add constraint FK_SKATER_C_SKATER_CO_SKATER foreign key (id_single)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table skater_discipline
   add constraint FK_SKATER_D_DISCIPLIN_DISCIPLI foreign key (id_discipline)
      references discipline (id_discipline)
      on delete restrict on update restrict;

alter table skater_discipline
   add constraint FK_SKATER_D_DISCIPLIN_SKATER foreign key (id_skater)
      references skater (id_skater)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_CHOREOGRA_CHOREOGR foreign key (id_choreographer)
      references choreographer (id_choreographer)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_PAIR_PROG_PAIR foreign key (id_pair)
      references pair (id_pair)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_PROGRAM_S_PROGRAM foreign key (id_program)
      references program (id_program)
      on delete restrict on update restrict;

alter table skater_programs
   add constraint FK_SKATER_P_SKATER_PR_SKATER foreign key (id_single)
      references skater (id_skater)
      on delete restrict on update restrict;

