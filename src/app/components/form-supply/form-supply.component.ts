import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { SupplyService } from 'src/app/services/supply.service';

@Component({
  selector: 'app-form-supply',
  templateUrl: './form-supply.component.html',
  styleUrls: ['./form-supply.component.scss'],
})
export class FormSupplyComponent {
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: SupplyService,
    private activatedRouter: ActivatedRoute
  ) {
    this.form = fb.group({
      plate: ['', [Validators.required, Validators.maxLength(10)]],
      mileage: ['', [Validators.required]],
      date: ['', [Validators.required]],
      hour: ['', [Validators.required]],
      total: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{2})?$/)]],
    });
  }
  id = this.activatedRouter.snapshot.params['id']
  private subscriptionGetSuppltById!: Subscription;
  private subscriptionOnSubmit!: Subscription;
  private subscriptionUpdate!: Subscription;
  ngOnInit(): void {
    if (this.id) {
      this.getSuppltById(this.id);
    }
  }
  getSuppltById(id: string) {
    this.subscriptionGetSuppltById = this.service.getById(id).subscribe({
      next: (value) => {
        this.form.get('plate')?.setValue(value.plate)
        this.form.get('mileage')?.setValue(value.mileage)
        this.form.get('date')?.setValue(value.date)
        this.form.get('hour')?.setValue(value.hour)
        this.form.get('total')?.setValue(value.total)
        this.form.updateValueAndValidity()
      },
      error: (err) => {
        this.router.navigateByUrl('..')
      },
    })
  }


  update(){
    const values = this.form.value
    values.id = this.id
    console.log(values)
    this.subscriptionUpdate = this.service.update(values).subscribe({
      next: (values) => {
        console.log("aaee",values)
        this.router.navigateByUrl("/home")
      },
      error: (error) => {

      }
    })
  }

  error = '';
  form: FormGroup;

  public submit() {
    console.log(this.form.value);
    if (this.form.valid) {
      if(this.id){
        this.update()
      }else{
        this.subscriptionOnSubmit = this.service.saveSupply(this.form).subscribe({
          next: (value) => {
            this.router.navigateByUrl("/home")
          },
          error: (error) => {},
        });
      }
    }
  }

  ngOnDestroy() {
    // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
    this.subscriptionGetSuppltById?.unsubscribe();
    this.subscriptionOnSubmit?.unsubscribe()
  }
}
