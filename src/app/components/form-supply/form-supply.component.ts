import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { SupplyService } from 'src/app/services/supply.service';

@Component({
  selector: 'app-form-supply',
  templateUrl: './form-supply.component.html',
  styleUrls: ['./form-supply.component.scss'],
})
export class FormSupplyComponent {
  constructor(private fb: FormBuilder, private router: Router, private service:SupplyService) {
    this.form = fb.group({
      plate: ['', [Validators.required]],
      mileage: ['', [Validators.required]],
      date: ['', [Validators.required]],
      hour: ['', [Validators.required]],
      total: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{2})?$/)]],
    });
  }
  ngOnInit(): void {}

  private subscription!: Subscription;

  error = '';
  form: FormGroup;

  public submit() {
    console.log(this.form.value);
    if (this.form.valid) {
      this.service.saveSupply(this.form).subscribe({
        next: (value) => {
          console.log(value)
        },
        error: (error) => {

        }
      })
    }
  }

  ngOnDestroy() {
    // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
    this.subscription?.unsubscribe();
  }
}
