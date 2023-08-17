import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Criteria } from 'src/app/model/criteria';
import { ReservationService } from 'src/app/services/reservation.service';
import {formatDate} from '@angular/common';
  

@Component({
  selector: 'app-find-flights',
  templateUrl: './find-flights.component.html',
  styleUrls: ['./find-flights.component.css']
})
export class FindFlightsComponent implements OnInit
{
  criteria:Criteria = new Criteria('', '', '');
  myDate = new Date();

  constructor(private service:ReservationService, private router:Router)
  {}

  ngOnInit() :void{}
  
   public OnSubmit()
   {
     this.criteria.departureDate = formatDate(this.myDate, 'dd-MM-yyyy', 'en');
     this.service.getFlights(this.criteria).subscribe((res: any)=>{
     this.service.data = res;
     console.log(res);
     this.router.navigate(['/displayFlights']);
    });
  }

}


