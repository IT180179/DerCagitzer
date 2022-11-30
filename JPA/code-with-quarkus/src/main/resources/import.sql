insert into Job(job_title, permission)
values('Chef', true),
      ('Koch', false),
      ('Kellner', false);

insert into Employee(username, first_name, last_name, password, job_id)
values('JosefC', 'Josef', 'Cagitz', 'password123', 1),
      ('NicoleC', 'Nicole', 'Cagitz', 'password123', 1),
      ('AnnikaC', 'Annika', 'Cagitz', 'password123', 2),
      ('KatharinaR', 'Katharina', 'Ransmair', 'password123', 3);

insert into Customer(first_name, last_name, email, password, telephoneNumber)
values('Fabian', 'Maar', 'fabian@maar.com', '123', '123456789'),
      ('David', 'Ursprung', 'david@ursprung.com', '123', '123456789'),
      ('Ana', 'Bikic', 'ana@bikic.com', '123', '123456789'),
      ('Hans Christian', 'Hammer', 'fabian@hammer.com', '123', '123456789'),
      ('Christian', 'Aberger', 'christian@aberger.com', '123', '123456789');

insert into Room(room_name, summer_winter)
values('Nebenzimmer', 'Winter'),
      ('Gastzimmer', 'Winter'),
      ('Bachstüberl', 'Winter'),
      ('Terrasse', 'Sommer'),
      ('Gastgarten', 'Sommer'),
      ('Saal', 'Winter');

insert into TableEntity(number, seats, room_id)
values(1, 4, 1),
      (2, 2, 1),
      (3, 4, 1),
      (4, 6, 1),
      (5, 6, 1),
      (6, 6, 1),
      (7, 4, 1),
      (8, 4, 1),
      (9, 4, 1),
      (10, 10, 1),
      (11, 8, 2),
      (12, 6, 2),
      (13, 4, 2),
      (21, 4, 3),
      (22, 4, 3),
      (23, 4, 3),
      (24, 8, 3),
      (25, 8, 3),
      (26, 4, 3),
      (27, 4, 3),
      (28, 4, 3),
      (31, 4, 4),
      (32, 2, 4),
      (33, 4, 4),
      (34, 2, 4),
      (35, 4, 4),
      (51, 4, 5),
      (52, 4, 5),
      (53, 4, 5),
      (54, 4, 5),
      (55, 2, 5),
      (56, 4, 5),
      (57, 4, 5),
      (61, 6, 5),
      (62, 4, 5),
      (63, 4, 5),
      (64, 2, 5),
      (65, 4, 5),
      (66, 4, 5),
      (71, 4, 5),
      (72, 4, 5),
      (73, 4, 5),
      (74, 6, 5),
      (75, 6, 5),
      (76, 6, 5),
      (101, 10, 5),
      (102, 10, 5),
      (103, 10, 5),
      (104, 10, 5),
      (105, 4, 5),
      (106, 4, 5),
      (107, 4, 5),
      (108, 4, 5),
      (109, 4, 5),
      (110, 4, 5);

insert into Reservation(employee_id, customer_id, customer_name, start_time, end_time, reservation_date, reservation_timestamp, person_amount, tableno)
values(1, 1, 'Maar', '11:00', '13:00', '06.11.2022', current_timestamp, 6, 1),
      (1, 2, 'Ursprung', '11:00', '13:00', '06.11.2022', current_timestamp, 3, 2),
      (2, 3, 'Bikic', '13:00', '15:00', '06.11.2022', current_timestamp, 6, 8),
      (1, 4, 'Hammer', '17:00', '19:00', '06.11.2022', current_timestamp, 5, 10),
      (2, 5, 'Aberger', '19:00', '21:00', '06.11.2022', current_timestamp, 4, 5);