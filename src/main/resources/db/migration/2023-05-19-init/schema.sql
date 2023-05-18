CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.application (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	"name" text NULL,
	status text NULL,
	CONSTRAINT application_pkey PRIMARY KEY (id)
);

CREATE TABLE public.club (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	director_name text NULL,
	members text NULL,
	"name" text NULL,
	CONSTRAINT club_pkey PRIMARY KEY (id)
);

CREATE TABLE public.disciplinary_practice (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	created_by uuid NULL,
	cause text NULL,
	practice_type text NULL,
	CONSTRAINT disciplinary_practice_pkey PRIMARY KEY (id)
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

CREATE TABLE public.professor_groups (
	professors_id uuid NOT NULL,
	groups_id uuid NOT NULL,
	CONSTRAINT professor_group_fkey1 FOREIGN KEY (groups_id) REFERENCES public."group"(id),
	CONSTRAINT professor_group_fkey2 FOREIGN KEY (professors_id) REFERENCES public.professor(id)
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
	platoon text NULL,
	"role" text NULL,
	telephone text NULL,
	application_id uuid NULL,
	disciplinary_practice_id uuid NULL,
	group_id uuid NULL,
	student_id uuid NULL,
	CONSTRAINT student_pkey PRIMARY KEY (id),
	CONSTRAINT student_fkey1 FOREIGN KEY (disciplinary_practice_id) REFERENCES public.disciplinary_practice(id),
	CONSTRAINT student_fkey2 FOREIGN KEY (application_id) REFERENCES public.application(id),
	CONSTRAINT student_fkey3 FOREIGN KEY (student_id) REFERENCES public.student(id),
	CONSTRAINT student_fkey4 FOREIGN KEY (group_id) REFERENCES public."group"(id)
);

CREATE TABLE public.student_lessons (
	students_id uuid NOT NULL,
	lessons_id uuid NOT NULL,
	CONSTRAINT student_lessons_pkey PRIMARY KEY (students_id, lessons_id),
	CONSTRAINT student_lessons_fkey1 FOREIGN KEY (lessons_id) REFERENCES public.lessons(id),
	CONSTRAINT student_lessons_fkey2 FOREIGN KEY (students_id) REFERENCES public.student(id)
);

CREATE TABLE public.club_students (
	clubs_id uuid NOT NULL,
	students_id uuid NOT NULL,
	CONSTRAINT club_student_fkey1 FOREIGN KEY (clubs_id) REFERENCES public.club(id),
	CONSTRAINT club_student_fkey2 FOREIGN KEY (students_id) REFERENCES public.student(id)
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