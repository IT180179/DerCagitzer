export interface Reservation {

  reservation_id: number;
  employee_id: number;
  customer_id: number;
  customer_name: string;
  start_time: number;
  end_time: number;
  reservation_date: Date;
  reservation_timestamp: Date;
  person_amount: number;
  tableEntity: TableEntity;

}
export interface TableEntity{
  seats: number;
  tableno: number;
  room: Room;
}

export interface Room{
  room_id: number;
  room_name: string;
}
