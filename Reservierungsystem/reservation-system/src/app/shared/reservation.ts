export interface Reservation {
  id: number;
  employee_id: number;
  customer_id: number;
  customer_name: string;
  reservation_time: number;
  reservation_date: Date;
  reservation_timestamp: Date;
  person_amount: number;
  tableno: number;

}
