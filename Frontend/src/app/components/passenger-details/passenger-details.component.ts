import { Component, OnInit, PACKAGE_ROOT_URL } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';
import { catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-passenger-details',
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.css']
})

export class PassengerDetailsComponent implements OnInit
{
  formIndexes: number[] = [0];
  noOfSeats:number = 1;
  id:string = '';
  flightD:any;
  reservation:Reservation = new Reservation("",0,[{ name:"", age:0, phone:"",email:""}]);

  constructor(private service:ReservationService, private router:Router, private activatedRoute:ActivatedRoute){
    this.formIndexes=[0];
  }

  ngOnInit(): void {
 
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id']; // Access the 'id' parameter from the URL
      console.log("FLIGHT ID :"+this.id); // You can use the 'id' in your component logic
    });
    this.service.getFlight(this.id).subscribe((res: any)=>{
      this.flightD = res;
      console.log("Selected FLight id : "+res);
    });
    
}

addFormFields() {
  this.reservation.pList.push({name:"", age:0, phone:"",email:""});
  const newIndex = this.formIndexes.length;
  this.formIndexes.push(newIndex);
  this.noOfSeats = this.noOfSeats+1;
}

  public onSubmit(): any {
    this.reservation.flightId = this.flightD.flightId;
    this.reservation.noOfSeats = this.noOfSeats;
    this.service.saveReservation(this.reservation)
      .pipe(
        catchError(error => {
          console.error('HTTP Error:', error);
          // Handle the error here, e.g., show an error message to the user
          return throwError('An error occurred. Please try again later.');
        })
      )
      .subscribe((res: any) => {
        this.router.navigate(['/confirm', res.reservationId]);
        console.log('Reservation successful!', res);
      });
  }
  

}
