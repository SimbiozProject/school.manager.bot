INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES (1, 'Minsk', 'Belarus', '1978-07-27', 'qwerty@mail.ru', 'Vova', 'Wef', '1234567', 1);
INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES (2, 'Moscow', 'Russia', '2002-03-11', 'dfghj@gmail.com', 'Katya', 'Wash', '4534545', 2);
INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES (3, 'Minsk', 'Belarus', '1992-07-23', 'zxcvbn@gmail.com', 'Luda', 'Tyk', '5675674', 3);
INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES (4, 'Kiev', 'Ukraine', '1991-07-01', 'plkmokmok@gmail.com', 'Olga', 'Lop', '2345675', 4);
INSERT INTO bot.crm_registration (user_id, city_name, country_name, date_of_birth, e_mail, first_name, last_name, phone_number, user_name) VALUES (5, 'Kiev', 'Ukraine', '2000-07-28', 'debbvvg@mail.ru', 'Denis', 'Bam', '5457890', 5);

INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES (1, true, false, '1978-07-27', 'qwerty@mail.ru', 'Vova', 'Wef', true, 'user', 'qaz', 1, 1);
INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES (2, true, false, '2002-03-11', 'dfghj@gmail.com', 'Katya', 'Wash', true, 'admin', 'wsx', 2, 2);
INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES (3, true, false, '1992-07-23', 'zxcvbn@gmail.com', 'Luda', 'Tyk', true, 'teacher', 'edc', 3, 3);
INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES (4, true, false, '1991-07-01', 'plkmokmok@gmail.com', 'Olga', 'Lop', true, 'student', 'rfv', 4, 4);
INSERT INTO bot.tg_user (id_user, active, block_user, date_of_birthday, email, first_name, last_name, payment, role, user_name, course_name, group_number) VALUES (5, false, true, '2000-07-28', 'debbvvg@mail.ru', 'Denis', 'Bam', false, 'student', 'tgb', 3, 3);

INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES (1, 11, 1);
INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES (2, 10, 2);
INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES (3, 9, 3);
INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES (4, 8, 4);
INSERT INTO bot.student_group (group_id, group_number, course_name) VALUES (5, 7, 5);

INSERT INTO bot.courses (course_id, course_name) VALUES (1, 'Level 0');
INSERT INTO bot.courses (course_id, course_name) VALUES (2, 'Level Advanced');
INSERT INTO bot.courses (course_id, course_name) VALUES (3, 'Level 1');
INSERT INTO bot.courses (course_id, course_name) VALUES (4, 'Level 2');
INSERT INTO bot.courses (course_id, course_name) VALUES (5, 'Level 3');

INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES (1, '1', 1, 1);
INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES (2, '2', 2, 2);
INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES (3, '3', 3, 3);
INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES (4, '1', 4, 4);
INSERT INTO bot.user_answer (user_id, answer, question_id, user_name) VALUES (5, '4', 5, 5);

INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES (1, 'photo', 2, 1);
INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES (2, 'doc', 3, 2);
INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES (3, 'photo', 6, 3);
INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES (4, 'photo', 7, 1);
INSERT INTO bot.hw_for_students (hw_id, hw_doc, lesson_number, group_number) VALUES (5, 'doc', 5, 4);

INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES (1, 'doc', 4, 1);
INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES (2, 'doc', 6, 2);
INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES (3, 'doc', 8, 3);
INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES (4, 'doc', 3, 4);
INSERT INTO bot.hw_from_students (student_id, students_hw, lesson_number, student_name) VALUES (5, 'photo', 5, 5);

INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (1, 'be', 'an', '1. My favorite color _____ green.', 'is', 'are', 'is');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (2, 'at', 'on', '2. We get up _____ 7 o’clock.', 'at', 'in', 'of');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (3, 'a', '-', '3. There is _____ milk in the fridge.', 'some', 'some', 'the');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (4, 'of', 'from', '4. Are you _____ Italy?', 'from', 'out', 'at');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (5, 'symbol', '-', '5. London is the _____ of England.', 'capital', 'capital', 'country');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (6, 'play', 'playing', '6. Last Sunday I _____ football with my friends.', 'played', 'played', 'plays');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (7, 'the best', 'well', '7. This is _____ film I have ever seen.', 'the best', 'good', 'better');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (8, 'do', 'will', '8. _____ I have a ticket to London?', 'can', 'should', 'should');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (9, 'often', 'long', '9. How _____ friends do you have?', 'many', 'much', 'many');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (10, 'that is', 'those are', '10. Excuse me, _____ my hat.', 'that is', 'those is', 'that are');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (11, '-', 'An', '11. _____ elephants are very beautiful animals.', '-', 'There', 'A');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (12, 'See you there', 'Nice to meet you', '12. How about going to the cinema? _____ ', 'Sounds good. What’s on?', 'Sounds good. What''s on?', 'Not a problem');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (13, 'which', 'who', '13. She is a woman _____ helped me with a job.', 'who', 'whose', 'where');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (14, 'said', 'talked', '14. They _____ me they would come the next day.', 'told', 'spoke', 'told');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (15, 'getting', 'gotten', '15. I hate _____ up early in the morning.', 'getting', 'get', 'got');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (16, 'will', 'can', '16. If I were you I _____ buy this car.', 'would', 'would', 'should');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (17, 'so he was ill', 'but is here', '17. He didn’t go to school _____', 'although he wasn’t ill', 'because he was there', 'although he wasn’t ill');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (18, 'on', 'in', '18. It’s not a good idea to leave electrical appliance _____ standby.', 'on', 'for', 'at');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (19, 'up', 'of', '19. When I want to relax I put my feet _____ ', 'up', 'on', 'down');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (20, 'obey', 'disobeying', '20. They are usually punished for _____ a teacher.', 'disobeying', 'disobey', 'obeying');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (21, 'know', 'have been knowing', '21. I _____ her since we were teenagers.', 'have known', 'knew', 'have known');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (22, 'When', 'As soon as', '22. _____ we came train had already departed.', 'By the time', 'By the time', 'Until');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (23, 'to see', 'seeing', '23. I remember _____ him at work and he was tired.', 'seeing', 'see', 'saw');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (24, 'couldn''t see', 'can''t have seen', '24. You _____ Jack in the gym because he had gone to France.', 'can’t have seen', 'can''t see', 'haven''t seen');
INSERT INTO bot.question_answer (id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer) VALUES (25, 'regarding', 'in order to', '25. I was frustrated at not having news _____ the interview I had had before.', 'regarding', 'relates', 'comparing with');