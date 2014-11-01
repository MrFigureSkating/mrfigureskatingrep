/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     29.10.2014 19:42:51                          */
/*==============================================================*/


drop index Classes_PK;

drop table Classes;

drop index Outcomes_PK;

drop table Outcomes;

drop index Relationship_1_FK;

drop index Ship_PK;

drop table Ship;

/*==============================================================*/
/* Table: Classes                                               */
/*==============================================================*/
create table Classes (
   class                VARCHAR(32)          not null,
   constraint PK_CLASSES primary key (class)
);

/*==============================================================*/
/* Index: Classes_PK                                            */
/*==============================================================*/
create unique index Classes_PK on Classes (
class
);

/*==============================================================*/
/* Table: Outcomes                                              */
/*==============================================================*/
create table Outcomes (
   ship                 VARCHAR(32)          not null,
   battle               INT4                 null,
   constraint PK_OUTCOMES primary key (ship)
);

/*==============================================================*/
/* Index: Outcomes_PK                                           */
/*==============================================================*/
create unique index Outcomes_PK on Outcomes (
ship
);

/*==============================================================*/
/* Table: Ship                                                  */
/*==============================================================*/
create table Ship (
   class                VARCHAR(32)          null,
   name                 VARCHAR(32)          not null,
   constraint PK_SHIP primary key (name)
);

/*==============================================================*/
/* Index: Ship_PK                                               */
/*==============================================================*/
create unique index Ship_PK on Ship (
name
);

/*==============================================================*/
/* Index: Relationship_1_FK                                     */
/*==============================================================*/
create  index Relationship_1_FK on Ship (
class
);

alter table Ship
   add constraint FK_SHIP_RELATIONS_CLASSES foreign key (class)
      references Classes (class)
      on delete restrict on update restrict;

