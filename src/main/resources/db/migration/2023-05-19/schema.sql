ALTER TABLE public.lessons ADD created timestamp,
ALTER TABLE public.lessons ADD subject_type text NULL,
ALTER TABLE public.lessons ADD professor_id uuid NULL;
ALTER TABLE public.lessons ADD CONSTRAINT professor_lesson_fkey FOREIGN KEY (id) REFERENCES public.professor(id);

ALTER TABLE public.professor ADD telegram_id text NULL;
ALTER TABLE public.student ADD telegram_id text NULL;

CREATE TABLE public.student_lesson (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	cause text NULL,
	mark int4 NULL,
	started_at timestamp NULL,
	is_absent boolean not NULL,
	is_finished boolean not NULL,
	student_id uuid NULL,
	lesson_id uuid NULL,
	CONSTRAINT student_lesson_pkey PRIMARY KEY (id),
	CONSTRAINT student_lesson_fkey1 FOREIGN KEY (student_id) REFERENCES public.student(id),
	CONSTRAINT student_lesson_fkey2 FOREIGN KEY (lessons_id) REFERENCES public.lessons(id)
);

CREATE TABLE public.club_members(
	clubs_id uuid NULL,
	members_id uuid NULL,
	CONSTRAINT club_members_fkey1 FOREIGN KEY (members_id) REFERENCES public.student(id),
	CONSTRAINT club_members_fkey2 FOREIGN KEY (clubs_id) REFERENCES public.club(id)
);
