import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CheckInData } from 'src/app/model/CheckInData';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.css']
})
export class CheckINComponent implements OnInit{

  reservationId:any;
  checkinReq:CheckInData = new CheckInData(0, false, 0);
  reservation:any;
  hide:boolean = true;
  displayMsg:boolean = false;

  constructor(private service:ReservationService, private router:Router){}

  ngOnInit() :void
  {
    this.displayMsg = false;
  }

  getReservationData():any
  {
    console.log("Reservation ID :", this.reservationId);
    this.service.getReservation(this.reservationId).subscribe((res: any)=>{
      this.reservation = res;
      console.log(this.checkinReq);
    });
    if(this.reservation.checkIn)
    {
      this.hide = true;
      this.displayMsg = true;
    }
    else
    {
      this.displayMsg = false;
      this.hide = false;
    }
      
  }

  startCheckIn():any
  {
    this.checkinReq.id = this.reservationId;
    this.checkinReq.checkIn = true;
    this.service.startCheckIn(this.checkinReq).subscribe((res: any) => {
      console.log(this.checkinReq);
      console.log("CHECK IN DONE!!" + res.reservationId);
      this.router.navigate(['/congrats']);
    });
  }
}
