--liquibase formatted sql

--changeset cloud-native:create-ads-table
CREATE SEQUENCE public.advertisement_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE public.ads (
	id int8 NOT NULL,
	contact varchar(255) NULL,
	currency varchar(255) NULL,
	createdat timestamp(6) NULL,
	modifiedat timestamp(6) NULL,
	price numeric(12, 3) NOT NULL,
	title varchar(255) NULL,
	version int8 NULL,
	PRIMARY KEY (id)
);