CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.club (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	director_name text NULL,
	members text NULL,
	"name" text NULL,
	CONSTRAINT club_pkey PRIMARY KEY (id)
);

CREATE TABLE public."group" (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	"name" text NULL,
	"number" int4 NULL,
	CONSTRAINT group_pkey PRIMARY KEY (id)
);

CREATE TABLE public.lessons (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	mark text NULL,
	CONSTRAINT lessons_pkey PRIMARY KEY (id)
);

CREATE TABLE public.professor (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	fullname text NULL,
	CONSTRAINT professor_pkey PRIMARY KEY (id)
);

CREATE TABLE public.student (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	vuc text NULL,
	address text NULL,
	birthdate timestamp NULL,
	course int4 NULL,
	fullname text NULL,
	institute text NULL,
	military_education text NULL,
	"role" text NULL,
	telephone text NULL,
	group_id uuid NULL,
	CONSTRAINT student_pkey PRIMARY KEY (id),
	CONSTRAINT student_fkey4 FOREIGN KEY (group_id) REFERENCES public."group"(id)
);

CREATE TABLE public.student_family(
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	address text NULL,
	fullname text NULL,
	relative_role text NULL,
	telephone text NULL,
	workplace text NULL,
	student_id uuid NULL,
	CONSTRAINT student_family_pkey PRIMARY KEY (id),
	CONSTRAINT student_family_student_fkey FOREIGN KEY (student_id) REFERENCES public.student(id)
);