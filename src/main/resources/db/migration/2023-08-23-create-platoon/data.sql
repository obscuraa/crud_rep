--changeset add_data
insert into public.professor (id, email, fullname, "password", telegram_id) values ('bc503e2d-b4ef-4022-b230-985f6612f963', 'prof1@mail.com', 'Первый проффесор', '12345', '3523c63d-1b28-4eca-beb0-94a3a4bc89ea');
insert into public.professor (id, email, fullname, "password", telegram_id) values ('f5306e1c-bfec-4daf-8c8d-ee54f8e3ec65', 'prof2@mail.com', 'Второй проффесор', '123456', '57f91c3f-87cb-4669-aaea-a9621b0434d6');

insert into public.student (id, vuc, address, birthdate, course, email, fullname, institute, military_education, "password", telegram_id, telephone, group_id) values ('72e81037-4a59-4773-912e-b27ddd62c44d', 'Стрелок', 'Spb', current_timestamp, '4', 'stud1@mail.com', 'Первый студент', 'MIRRA', 'None', '12343', '5a38a66f-6669-42f9-ab32-1cadf45fa000', '234-15-34', null);
insert into public.student (id, vuc, address, birthdate, course, email, fullname, institute, military_education, "password", telegram_id, telephone, group_id) values ('dd4febbe-5e57-4062-91df-640bc2798be2', 'Танкист', 'Spb', current_timestamp, '4', 'stud2@mail.com', 'Второй студент', 'MIRRA', 'None', '12343', '58d18607-6f0f-4a68-80ac-8e1eb1c86d37', '234-15-34', null);

insert into public.student_family (id, address, fullname, relative_role, telephone, workplace, student_id) values ('622bc5b5-d9db-49cf-8f76-e4d48c7586fd', 'Spb', 'Мать первого студента', 'MOTHER', '123-54-67', 'Sber', '72e81037-4a59-4773-912e-b27ddd62c44d');
insert into public.student_family (id, address, fullname, relative_role, telephone, workplace, student_id) values ('bc2cc7d1-659b-4d0c-96e3-145e02dafd29', 'Spb', 'Отец первого студента', 'FATHER', '124-54-67', 'Sber', '72e81037-4a59-4773-912e-b27ddd62c44d');
insert into public.student_family (id, address, fullname, relative_role, telephone, workplace, student_id) values ('316f21b5-4eb9-4309-955b-26590935e0b7', 'Spb', 'Мать второго студента', 'MOTHER', '333-54-67', 'Мирра', 'dd4febbe-5e57-4062-91df-640bc2798be2');
insert into public.student_family (id, address, fullname, relative_role, telephone, workplace, student_id) values ('9e2324bf-3b34-4058-b7d7-a43edbef93d7', 'Spb', 'Отец второго студента', 'FATHER', '546-54-67', 'Мирра', 'dd4febbe-5e57-4062-91df-640bc2798be2');

insert into public.club (id, director_name, "name") values ('2e315afe-f929-4589-8bba-98018c17558e', 'Василий Пупкин', 'Стрелковый клуб');
insert into public.club (id, director_name, "name") values ('33c215c7-60d6-468a-bf84-d24606157b3e', 'Иван Петров', 'Танцевальный клуб');

insert into public.club_members (clubs_id, members_id) values ('2e315afe-f929-4589-8bba-98018c17558e', '72e81037-4a59-4773-912e-b27ddd62c44d');
insert into public.club_members (clubs_id, members_id) values ('33c215c7-60d6-468a-bf84-d24606157b3e', 'dd4febbe-5e57-4062-91df-640bc2798be2');

insert into public.platoon (id, "number", "commander_id") values ('9193db67-0160-4bf2-9663-7cbb5c8d69ec', 'Первый взвод', '72e81037-4a59-4773-912e-b27ddd62c44d');

insert into public."group" (id, "name", "number", "commander_id", platoon_id) values ('48a5dbf6-c872-4132-bc92-0d823802c849', 'Первое отделение', '345', 'dd4febbe-5e57-4062-91df-640bc2798be2', '9193db67-0160-4bf2-9663-7cbb5c8d69ec');

insert into public.lessons (id, created, subject_type, professor_id) values ('41b3c417-ff71-4b4b-a8c2-5eb55cec65a5', current_timestamp, 'Стрельба', 'bc503e2d-b4ef-4022-b230-985f6612f963');
insert into public.lessons (id, created, subject_type, professor_id) values ('2ee39cf1-a805-46e4-87dc-33a9289983fc', current_timestamp, 'Ведение боевых действий в городской местности', 'f5306e1c-bfec-4daf-8c8d-ee54f8e3ec65');

insert into public.student_lesson (id, cause, is_absent, is_finished, mark, started_at, lesson_id, student_id) values ('184f3dd0-0b41-455d-8229-e2a5d50069ed', 'Опоздание', true, true, null, current_timestamp, '41b3c417-ff71-4b4b-a8c2-5eb55cec65a5', '72e81037-4a59-4773-912e-b27ddd62c44d');
insert into public.student_lesson (id, cause, is_absent, is_finished, mark, started_at, lesson_id, student_id) values ('ee07c5e8-f9ec-4888-bd74-9f5c8cfdff40', null, false, true, '5', current_timestamp, '41b3c417-ff71-4b4b-a8c2-5eb55cec65a5', 'dd4febbe-5e57-4062-91df-640bc2798be2');