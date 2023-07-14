CREATE TABLE IF NOT EXISTS public.platoon(
    id uuid NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NULL,
    commander_id uuid REFERENCES public.student(id),
    amount int4 NULL
);

ALTER TABLE public.group ADD COLUMN commander_id uuid REFERENCES public.student(id);