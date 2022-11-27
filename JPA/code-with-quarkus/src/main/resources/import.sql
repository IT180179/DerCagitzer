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

insert into TableEntity(seats, room_id)
values(4, 1),
      (4, 1),
      (4, 1),
      (4, 1),
      (4, 2),
      (4, 2),
      (4, 2),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3),
      (4, 3);

insert into Reservation(employee_id, customer_id, customer_name, start_time, end_time, reservation_date, reservation_timestamp, person_amount, tableno)
values(1, 1, 'Maar', '11:00', '13:00', '06.11.2022', current_timestamp, 6, 1),
      (1, 2, 'Ursprung', '11:00', '13:00', '06.11.2022', current_timestamp, 3, 2),
      (2, 3, 'Bikic', '13:00', '15:00', '06.11.2022', current_timestamp, 6, 8),
      (1, 4, 'Hammer', '17:00', '19:00', '06.11.2022', current_timestamp, 5, 10),
      (2, 5, 'Aberger', '19:00', '21:00', '06.11.2022', current_timestamp, 4, 5);