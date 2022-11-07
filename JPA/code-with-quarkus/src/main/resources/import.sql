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
values('Raum 1', 'Winter'),
      ('Raum 2', 'Winter'),
      ('Raum 3', 'Winter'),
      ('Raum 4', 'Winter'),
      ('Saal 1', 'Winter'),
      ('Saal 2', 'Winter'),
      ('Terrasse', 'Sommer'),
      ('Gastgarten', 'Sommer');

insert into TableEntity(seats, room_id)
values(6, 1),
      (4, 1),
      (4, 1),
      (4, 1),
      (4, 2),
      (2, 2),
      (4, 2),
      (6, 3),
      (6, 3),
      (6, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (5, 3);

insert into Reservation(employee_id, customer_id, customer_name, start_time, end_time, reservation_date, reservation_timestamp, person_amount, tableno)
values(1, 1, 'Maar', '11:30', '13:00', '06.11.2022', current_timestamp, 6, 1),
      (1, 2, 'Ursprung', '11:30', '13:00', '06.11.2022', current_timestamp, 3, 2),
      (2, 3, 'Bikic', '13:00', '14:30', '06.11.2022', current_timestamp, 6, 8),
      (1, 4, 'Hammer', '17:30', '19:00', '06.11.2022', current_timestamp, 5, 10),
      (2, 5, 'Aberger', '19:00', '21:30', '06.11.2022', current_timestamp, 4, 5);