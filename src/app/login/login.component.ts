import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(
    fb: FormBuilder,
  ) {
    this.form = fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  title = 'front-end';
  form: FormGroup;
   submit() {
      if (this.form.valid) {
        this.submitEM.emit(this.form.value);
      }
    }
    @Input() error: string | null = "";
  
    @Output() submitEM = new EventEmitter();
}
