CREATE TABLE public.platoon (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	number text NULL,
	commander_id uuid NULL,
	CONSTRAINT platoon_pkey PRIMARY KEY (id),
	CONSTRAINT platoon_fkey1 FOREIGN KEY (commander_id) REFERENCES public.student(id)
);

ALTER TABLE public."group" ADD COLUMN platoon_id uuid NULL;

ALTER TABLE public."group" ADD CONSTRAINT group_platoon_fkey FOREIGN KEY (platoon_id) REFERENCES public.platoon(id);

ALTER TABLE public."group" ADD COLUMN commander_id uuid NULL;

ALTER TABLE public."group" ADD CONSTRAINT group_student_fkey2 FOREIGN KEY (commander_id) REFERENCES public.student(id);

ALTER TABLE public.lessons ADD CONSTRAINT lesson_professor_fkey FOREIGN KEY (professor_id) REFERENCES public.professor(id);
