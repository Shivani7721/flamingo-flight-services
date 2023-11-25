import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})

export class ConfirmComponent implements OnInit
{
  reservationId:number = 0;
  savedReservation:any;
   
  constructor(private service:ReservationService, private route:ActivatedRoute, private router:Router){}

  ngOnInit() :void
  {
    this.route.params.subscribe(params => {
      this.reservationId = params['id']; // Access the 'id' parameter from the URL
      console.log("RESERVATION ID :"+this.reservationId); // You can use the 'id' in your component logic
    });

    this.service.getReservationAmount(this.reservationId).subscribe((res: any)=>{
      this.savedReservation = res;
      console.log(this.savedReservation);
    });
  }

  startCheckIn():any
  {
    this.router.navigate(['/checkin']);
  }
}
