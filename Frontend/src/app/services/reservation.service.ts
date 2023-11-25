import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Criteria } from '../model/criteria';
import { Reservation } from '../model/reservation';
import { Observable } from 'rxjs';
import { CheckInData } from '../model/CheckInData';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  flightUrl:string = "http://localhost:8082/flights";
  reservationUrl:string = "http://localhost:8082/reservation";
  data:any;

  constructor(private _httpClient:HttpClient) { }

  public getFlights(criteria:Criteria):any
  {
     return this._httpClient.get(this.flightUrl+"/" + criteria.from + "/" + criteria.to + "/" + criteria.departureDate);
  }

  public getFlight(id: string):any
  {
     return this._httpClient.get(this.flightUrl+"/" + id);
  }

  public saveReservation(reservation:Reservation):any
  {
     return this._httpClient.post(this.reservationUrl, reservation);
  }

  public getReservation(id: number):any
  {
     return this._httpClient.get(this.reservationUrl+"/" + id);
  }

  public getReservationAmount(id: number):any
  {
     return this._httpClient.get(this.reservationUrl+"/amount/" + id);
  }

  public startCheckIn(checkInReq:CheckInData):any
  {
     return this._httpClient.put(this.reservationUrl, checkInReq);
  }

}
