import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindFlightsComponent } from './components/find-flights/find-flights.component';
import { DisplayFlightsComponent } from './components/display-flights/display-flights.component';
import { PassengerDetailsComponent } from './components/passenger-details/passenger-details.component';
import { ConfirmComponent } from './components/confirm/confirm.component';
import { CheckINComponent } from './components/check-in/check-in.component';
import { CongratrulationsComponent } from './congratrulations/congratrulations.component';

const routes: Routes = [
  {
    path :'',
    redirectTo:'',
    pathMatch:'full'
  },
  {
    path : 'findFlights',
    component: FindFlightsComponent
  },
  {
    path : 'displayFlights',
    component: DisplayFlightsComponent
  },
  {
    path : 'passengerDetails/:id',
    component: PassengerDetailsComponent
  },
  {
    path : 'confirm/:id',
    component: ConfirmComponent
  },
  {
    path : 'checkin',
    component: CheckINComponent
  },
  {
    path : 'congrats',
    component: CongratrulationsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
