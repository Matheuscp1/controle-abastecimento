import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-form-supply',
  templateUrl: './form-supply.component.html',
  styleUrls: ['./form-supply.component.scss'],
})
export class FormSupplyComponent {
  constructor(private fb: FormBuilder, private router: Router) {
    this.form = fb.group({
      car: ['', [Validators.required]],
      km: ['', [Validators.required]],
      date: ['', [Validators.required]],
      hour: ['', [Validators.required]],
      total: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{2})?$/)],],
    });
  }
  ngOnInit(): void {}

  private subscription!: Subscription;

  error = '';
  form: FormGroup;

  public submit() {
    console.log(this.form.value)
    if (this.form.valid) {
    }
  }

  ngOnDestroy() {
    // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
    this.subscription?.unsubscribe();
  }
}
