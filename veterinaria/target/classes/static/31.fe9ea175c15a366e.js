"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[31],{74061:(R,p,o)=>{o.d(p,{m:()=>b});var e=o(17705),h=o(60177),a=o(99213),d=o(52920),t=o(18498);function l(g,v){if(1&g&&(e.j41(0,"div",7)(1,"mat-icon",5),e.EFF(2,"chevron_right"),e.k0s(),e.j41(3,"div",6),e.EFF(4),e.k0s()()),2&g){const _=v.$implicit;e.R7$(4),e.JRh(_)}}const c=function(){return["/"]};let b=(()=>{class g{constructor(){this.crumbs=[]}ngOnInit(){}static{this.\u0275fac=function(E){return new(E||g)}}static{this.\u0275cmp=e.VBU({type:g,selectors:[["fury-breadcrumbs"]],inputs:{current:"current",crumbs:"crumbs"},decls:11,vars:5,consts:[[1,"title"],["fxLayout","row","fxLayoutAlign","start center",1,"crumbs"],[1,"crumb","home",3,"routerLink"],["class","crumb","fxLayout","row","fxLayoutAlign","start center",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","start center",1,"crumb","current"],[1,"chevron"],[1,"link"],["fxLayout","row","fxLayoutAlign","start center",1,"crumb"]],template:function(E,D){1&E&&(e.j41(0,"div",0),e.EFF(1),e.k0s(),e.j41(2,"div",1)(3,"a",2),e.EFF(4,"Home"),e.k0s(),e.DNE(5,l,5,1,"div",3),e.j41(6,"div",4)(7,"mat-icon",5),e.EFF(8,"chevron_right"),e.k0s(),e.j41(9,"div",6),e.EFF(10),e.k0s()()()),2&E&&(e.R7$(1),e.JRh(D.current),e.R7$(2),e.Y8G("routerLink",e.lJ4(4,c)),e.R7$(2),e.Y8G("ngForOf",D.crumbs),e.R7$(5),e.JRh(D.current))},dependencies:[h.Sq,a.An,d.DJ,d.sA,t.Wk],styles:["[_nghost-%COMP%]{display:block}.title[_ngcontent-%COMP%]{font:var(--font-title);font-weight:400}.crumb[_ngcontent-%COMP%], .link[_ngcontent-%COMP%]{text-decoration:none;transition:color .4s cubic-bezier(.25,.8,.25,1);font:var(--font-body-1)}.link[_ngcontent-%COMP%]{cursor:pointer}.chevron[_ngcontent-%COMP%]{font-size:18px;height:18px;width:18px;margin-left:6px;margin-right:6px;-webkit-user-select:none;user-select:none;cursor:default}"]})}}return g})()},75063:(R,p,o)=>{o.d(p,{s:()=>L});var e=o(17705),h=o(33726),a=o(23294),d=o(70152),t=o(60177),l=o(99213),c=o(88834),b=o(59115),g=o(82765),v=o(52920),_=o(89417);const E=["filter"];function D(y,O){if(1&y&&(e.j41(0,"div",5)(1,"div",6),e.EFF(2),e.k0s(),e.j41(3,"div",7)(4,"mat-icon",8),e.EFF(5,"search"),e.k0s(),e.nrm(6,"input",9,10),e.k0s(),e.j41(8,"button",11)(9,"mat-icon"),e.EFF(10,"filter_list"),e.k0s()(),e.SdG(11,1),e.k0s()),2&y){const u=e.XpG(),m=e.sdS(3);e.R7$(2),e.JRh(u.name),e.R7$(6),e.Y8G("matMenuTriggerFor",m)}}function T(y,O){if(1&y){const u=e.RV6();e.j41(0,"div",12),e.bIt("click",function(C){const U=e.eBV(u).$implicit,P=e.XpG();return e.Njj(P.toggleColumnVisibility(U,C))}),e.j41(1,"mat-checkbox",13,14),e.bIt("ngModelChange",function(C){const U=e.eBV(u).$implicit;return e.Njj(U.visible=C)})("click",function(C){return C.stopPropagation()}),e.EFF(3),e.k0s()()}if(2&y){const u=O.$implicit;e.R7$(1),e.Y8G("ngModel",u.visible),e.R7$(2),e.SpI(" ",u.name," ")}}const I=["*",[["",8,"actions"]]],j=["*",".actions"];let L=(()=>{class y{constructor(u){this.cd=u,this.filterChange=new e.bkB}ngAfterViewInit(){this.hideHeader||(0,h.R)(this.filter.nativeElement,"keyup").pipe((0,a.F)(),(0,d.B)(150)).subscribe(()=>{this.filterChange.emit(this.filter.nativeElement.value)})}toggleColumnVisibility(u,m){m.stopPropagation(),m.stopImmediatePropagation(),u.visible=!u.visible,this.cd.markForCheck()}static{this.\u0275fac=function(m){return new(m||y)(e.rXU(e.gRc))}}static{this.\u0275cmp=e.VBU({type:y,selectors:[["fury-list"]],viewQuery:function(m,C){if(1&m&&e.GBs(E,5),2&m){let M;e.mGM(M=e.lsd())&&(C.filter=M.first)}},inputs:{name:"name",columns:"columns",hideHeader:"hideHeader"},outputs:{filterChange:"filterChange"},ngContentSelectors:j,decls:6,vars:2,consts:[[1,"fury-list-table"],["class","fury-list-header","fxLayout","row","fxLayoutAlign","start center","fxLayoutGap","8px","fxLayoutGap.gt-xs","24px",4,"ngIf"],["yPosition","below","xPosition","before"],["columnFilter","matMenu"],["class","checkbox-item mat-menu-item",3,"click",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","start center","fxLayoutGap","8px","fxLayoutGap.gt-xs","24px",1,"fury-list-header"],[1,"fury-list-name"],["fxLayout","row","fxLayoutAlign","start center","fxFlex",""],[1,"fury-filter-input-icon"],["fxFlex","","placeholder","Search\u2026",1,"fury-filter-input"],["filter",""],["type","button","mat-icon-button","",1,"fury-column-filter",3,"matMenuTriggerFor"],[1,"checkbox-item","mat-menu-item",3,"click"],[1,"checkbox",3,"ngModel","ngModelChange","click"],["checkbox",""]],template:function(m,C){1&m&&(e.NAR(I),e.j41(0,"div",0),e.DNE(1,D,12,2,"div",1),e.j41(2,"mat-menu",2,3),e.DNE(4,T,4,2,"div",4),e.k0s(),e.SdG(5),e.k0s()),2&m&&(e.R7$(1),e.Y8G("ngIf",!C.hideHeader),e.R7$(3),e.Y8G("ngForOf",C.columns))},dependencies:[t.Sq,t.bT,l.An,c.iY,b.kk,b.Cp,g.So,v.DJ,v.BO,v.sA,v.UI,_.BC,_.vS],styles:[".fury-list-table{display:flex;flex-direction:column}.fury-list-table .fury-list-header{padding-left:24px;padding-right:24px;height:64px;border-top-left-radius:8px;border-top-right-radius:8px}@media screen and (max-width: 599px){.fury-list-table .fury-list-header{height:auto;padding-top:24px;padding-bottom:24px}}.fury-list-table .fury-list-header .fury-list-name{font-size:20px;line-height:32px;font-weight:500;padding-right:24px}@media screen and (max-width: 599px){.fury-list-table .fury-list-header .fury-list-name{border-right:none}}.fury-list-table .fury-list-header .fury-filter-input{font-size:16px;line-height:1.125;border:none;height:32px}.fury-list-table .fury-list-header .fury-filter-input:focus{outline:none}.fury-list-table .fury-list-header .fury-filter-input-icon{width:1.2em;vertical-align:bottom;height:22px;font-size:22px;margin-right:8px}.fury-list-table table{width:100%}.fury-list-table .mat-mdc-header-row .mat-mdc-header-cell .mat-sort-header-button{text-transform:uppercase}.fury-list-table .mat-mdc-cell.image-cell,.fury-list-table .mat-mdc-header-cell.image-cell{flex:0;width:59px}.fury-list-table .mat-mdc-cell.image-cell img,.fury-list-table .mat-mdc-header-cell.image-cell img{border-radius:50%;height:35px;width:35px;margin-right:24px;vertical-align:middle}.fury-list-table .mat-mdc-cell,.fury-list-table .mat-mdc-header-cell{white-space:nowrap;padding-left:12px;padding-right:12px}.fury-list-table .mat-mdc-cell.actions-cell,.fury-list-table .mat-mdc-header-cell.actions-cell{flex:0;width:40px;overflow:visible}.fury-list-table .paginator{display:block}.checkbox-item{padding-right:32px;padding-left:8px}\n"],encapsulation:2})}}return y})()},91398:(R,p,o)=>{o.d(p,{H:()=>t});var e=o(60177),h=o(89417),a=o(12198),d=o(17705);let t=(()=>{class l{static{this.\u0275fac=function(g){return new(g||l)}}static{this.\u0275mod=d.$C({type:l})}static{this.\u0275inj=d.G2t({imports:[e.MD,a.G,h.YN]})}}return l})()},15551:(R,p,o)=>{o.d(p,{M:()=>h});var e=o(17705);let h=(()=>{class a{constructor(){}static{this.\u0275fac=function(l){return new(l||a)}}static{this.\u0275dir=e.FsC({type:a,selectors:[["","furyPageLayoutContent",""],["fury-page-layout-content"]],hostAttrs:[1,"fury-page-layout-content"]})}}return a})()},53007:(R,p,o)=>{o.d(p,{M:()=>h});var e=o(17705);let h=(()=>{class a{constructor(){}static{this.\u0275fac=function(l){return new(l||a)}}static{this.\u0275dir=e.FsC({type:a,selectors:[["","furyPageLayoutHeader",""],["fury-page-layout-header"]],hostAttrs:[1,"fury-page-layout-header"]})}}return a})()},43655:(R,p,o)=>{o.d(p,{T:()=>h});var e=o(17705);let h=(()=>{class a{constructor(){this.mode="simple"}get isCard(){return"card"===this.mode}get isSimple(){return"simple"===this.mode}static{this.\u0275fac=function(l){return new(l||a)}}static{this.\u0275dir=e.FsC({type:a,selectors:[["","furyPageLayout",""],["fury-page-layout"]],hostAttrs:[1,"fury-page-layout"],hostVars:4,hostBindings:function(l,c){2&l&&e.AVh("fury-page-layout-card",c.isCard)("fury-page-layout-simple",c.isSimple)},inputs:{mode:"mode"}})}}return a})()},33031:(R,p,o)=>{o.r(p),o.d(p,{UsuarioModule:()=>it});var e=o(60177),h=o(18498),a=o(9159),d=o(34006),t=o(17705),l=o(97405),c=o(89417),b=o(52920),g=o(99631),v=o(86467),_=o(88834),E=o(82798),D=o(86600);function T(r,f){if(1&r&&(t.j41(0,"mat-option",12),t.EFF(1),t.k0s()),2&r){const n=f.$implicit;t.Y8G("value",n.id),t.R7$(1),t.SpI(" ",n.name," ")}}function I(r,f){if(1&r&&(t.j41(0,"button",13),t.EFF(1,"Crear Usuario "),t.k0s()),2&r){const n=t.XpG();t.Y8G("disabled",!n.form.valid)}}function j(r,f){if(1&r&&(t.j41(0,"button",13),t.EFF(1,"Actualizar Usuario "),t.k0s()),2&r){const n=t.XpG();t.Y8G("disabled",!n.form.valid)}}let L=(()=>{class r{constructor(n,i,s,x){this.defaults=n,this.dialogRef=i,this.apiClient=s,this.fb=x,this.mode="create",this.roleList=[]}ngOnInit(){this.defaults?this.mode="update":this.defaults={},this.form=this.fb.group({id:[this.defaults.firstName||null],name:[this.defaults.name||""],username:[this.defaults.name||""],contrasenia:[this.defaults.contrasenia||""],idAuthRole:[this.defaults.idAuthRole||""]}),this.apiClient.getRequest("/api/role").subscribe({next:n=>{this.roleList=n},error:n=>{console.error(n)}})}save(){"create"===this.mode?this.createCustomer():"update"===this.mode&&this.updateCustomer()}createCustomer(){this.dialogRef.close(this.form.value)}updateCustomer(){const n=this.form.value;n.id=this.defaults.id,this.dialogRef.close(n)}isCreateMode(){return"create"===this.mode}isUpdateMode(){return"update"===this.mode}static{this.\u0275fac=function(i){return new(i||r)(t.rXU(d.Vh),t.rXU(d.CP),t.rXU(l.f),t.rXU(c.ze))}}static{this.\u0275cmp=t.VBU({type:r,selectors:[["fury-crear-actualizar-usuario"]],decls:26,vars:5,consts:[["mat-dialog-title",""],[3,"formGroup","ngSubmit"],[1,"person"],["fxLayout","column","fxLayout.gt-sm","row","fxLayoutGap.gt-sm","24px"],["fxFlex",""],["type","text","formControlName","name","matInput",""],["type","text","formControlName","username","matInput",""],["type","password","formControlName","contrasenia","matInput",""],["formControlName","idAuthRole"],[3,"value",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","end center"],["mat-flat-button","","color","primary",3,"disabled",4,"ngIf"],[3,"value"],["mat-flat-button","","color","primary",3,"disabled"]],template:function(i,s){1&i&&(t.j41(0,"div",0),t.EFF(1),t.k0s(),t.j41(2,"form",1),t.bIt("ngSubmit",function(){return s.save()}),t.j41(3,"mat-dialog-content")(4,"div",2)(5,"div",3)(6,"mat-form-field",4)(7,"mat-label"),t.EFF(8,"Nombre"),t.k0s(),t.nrm(9,"input",5),t.k0s(),t.j41(10,"mat-form-field",4)(11,"mat-label"),t.EFF(12,"UserName"),t.k0s(),t.nrm(13,"input",6),t.k0s(),t.j41(14,"mat-form-field",4)(15,"mat-label"),t.EFF(16,"Password"),t.k0s(),t.nrm(17,"input",7),t.k0s(),t.j41(18,"mat-form-field")(19,"mat-label"),t.EFF(20,"Rol"),t.k0s(),t.j41(21,"mat-select",8),t.DNE(22,T,2,2,"mat-option",9),t.k0s()()()()(),t.j41(23,"mat-dialog-actions",10),t.DNE(24,I,2,1,"button",11),t.DNE(25,j,2,1,"button",11),t.k0s()()),2&i&&(t.R7$(1),t.SpI("",s.isCreateMode()?"Crear":"Actualizar"," Usuario"),t.R7$(1),t.Y8G("formGroup",s.form),t.R7$(20),t.Y8G("ngForOf",s.roleList),t.R7$(2),t.Y8G("ngIf",s.isCreateMode()),t.R7$(1),t.Y8G("ngIf",s.isUpdateMode()))},dependencies:[e.Sq,e.bT,c.qT,c.me,c.BC,c.cb,c.j4,c.JD,b.DJ,b.BO,b.sA,b.UI,d.BI,d.Yi,d.E7,g.fg,v.rl,v.nJ,_.$z,E.VO,D.wT]})}}return r})();var y=o(74061),O=o(43655),u=o(53007),m=o(15551),C=o(75063),M=o(82765),U=o(99213),P=o(59115),A=o(96695),k=o(2042);function G(r,f){1&r&&(t.j41(0,"th",15)(1,"mat-checkbox",16),t.bIt("click",function(i){return i.stopPropagation()}),t.k0s()())}function $(r,f){1&r&&(t.j41(0,"td",17)(1,"mat-checkbox",16),t.bIt("click",function(i){return i.stopPropagation()}),t.k0s()())}function B(r,f){if(1&r&&(t.j41(0,"th",22),t.EFF(1),t.k0s()),2&r){const n=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",n.name,"")}}function S(r,f){if(1&r&&(t.j41(0,"td",23),t.EFF(1),t.k0s()),2&r){const n=f.$implicit,i=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",n[i.property]," ")}}function N(r,f){if(1&r&&(t.qex(0,19),t.DNE(1,B,2,1,"th",20),t.DNE(2,S,2,1,"td",21),t.bVm()),2&r){const n=t.XpG().$implicit;t.Y8G("matColumnDef",n.property)}}function Y(r,f){if(1&r&&(t.qex(0),t.DNE(1,N,3,1,"ng-container",18),t.bVm()),2&r){const n=f.$implicit;t.R7$(1),t.Y8G("ngIf",n.isModelProperty)}}function V(r,f){1&r&&t.nrm(0,"th",24)}function W(r,f){if(1&r){const n=t.RV6();t.j41(0,"td",17)(1,"button",25),t.bIt("click",function(s){return s.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",26,27)(6,"button",28),t.bIt("click",function(){const x=t.eBV(n).$implicit,F=t.XpG();return t.Njj(F.updateUser(x))}),t.j41(7,"span"),t.EFF(8,"Modify"),t.k0s()(),t.j41(9,"button",28),t.bIt("click",function(){const x=t.eBV(n).$implicit,F=t.XpG();return t.Njj(F.deleteUser(x))}),t.j41(10,"span"),t.EFF(11,"Delete"),t.k0s()()()()}if(2&r){const n=t.sdS(5);t.R7$(1),t.Y8G("matMenuTriggerFor",n)}}function K(r,f){1&r&&t.nrm(0,"tr",29)}function z(r,f){if(1&r){const n=t.RV6();t.j41(0,"tr",30),t.bIt("click",function(){const x=t.eBV(n).$implicit,F=t.XpG();return t.Njj(F.updateUser(x))}),t.k0s()}}const H=function(){return["Seguridad"]},X=function(){return[]},J=[{path:"",component:(()=>{class r{get visibleColumns(){return this.columns.filter(n=>n.visible).map(n=>n.property)}constructor(n,i){this.apiClient=n,this.dialog=i,this.dataSource=new a.I6([]),this.columns=[{name:"ID",property:"id",visible:!0,isModelProperty:!0},{name:"Name",property:"name",visible:!0,isModelProperty:!0},{name:"UserName",property:"username",visible:!0,isModelProperty:!0},{name:"Rol",property:"idAuthRole",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0}],this.pageSize=10}ngOnInit(){this.getUsers()}getUsers(){this.apiClient.getRequest("/api/usuario").subscribe({next:n=>{this.dataSource.data=n},error:n=>{console.error(n)}})}onFilterChange(n){console.info(event),this.dataSource&&(n=(n=n.trim()).toLowerCase(),this.dataSource.filter=n)}updateUser(n){this.dialog.open(L,{data:n}).afterClosed().subscribe(i=>{i?this.apiClient.putRequest(`/api/usuario/${i.id}`,i.id,i).subscribe({next:s=>{this.getUsers()},error:s=>{console.error(s)}}):console.info("Cancelado")})}deleteUser(n){console.info("deleteUser",n),this.apiClient.deleteRequest(n.id,"/api/usuario").subscribe({next:i=>{this.getUsers()},error:i=>{console.error(i)}})}createUser(){this.dialog.open(L).afterClosed().subscribe(n=>{n?this.apiClient.postRequest("/api/usuario",n).subscribe({next:i=>{this.getUsers()},error:i=>{console.error(i)}}):console.info("Cancelado")})}static{this.\u0275fac=function(i){return new(i||r)(t.rXU(l.f),t.rXU(d.bZ))}}static{this.\u0275cmp=t.VBU({type:r,selectors:[["fury-usuario"]],inputs:{columns:"columns"},decls:20,vars:9,consts:[["mode","card"],["current","Usuarios",3,"crumbs"],["name","Usuarios",3,"columns","filterChange"],[1,"actions"],["type","button","mat-mini-fab","","color","primary",1,"create",3,"click"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","checkbox"],["class","actions-cell","mat-header-cell","",4,"matHeaderCellDef"],["class","actions-cell","mat-cell","",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions"],["class","actions-cell","mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["class","clickable route-animations-elements","mat-row","",3,"click",4,"matRowDef","matRowDefColumns"],[1,"paginator",3,"pageSize"],["mat-header-cell","",1,"actions-cell"],["color","primary",3,"click"],["mat-cell","",1,"actions-cell"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-cell","","mat-sort-header","",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu","matMenu"],["mat-menu-item","",3,"click"],["mat-header-row",""],["mat-row","",1,"clickable","route-animations-elements",3,"click"]],template:function(i,s){1&i&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2),t.bIt("filterChange",function(F){return s.onFilterChange(F)}),t.j41(5,"div",3)(6,"button",4),t.bIt("click",function(){return s.createUser()}),t.j41(7,"mat-icon"),t.EFF(8,"add"),t.k0s()()(),t.j41(9,"table",5),t.qex(10,6),t.DNE(11,G,2,0,"th",7),t.DNE(12,$,2,0,"td",8),t.bVm(),t.DNE(13,Y,2,1,"ng-container",9),t.qex(14,10),t.DNE(15,V,1,0,"th",11),t.DNE(16,W,12,1,"td",8),t.bVm(),t.DNE(17,K,1,0,"tr",12),t.DNE(18,z,1,0,"tr",13),t.k0s(),t.nrm(19,"mat-paginator",14),t.k0s()()()),2&i&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(7,H)),t.R7$(2),t.Y8G("columns",t.lJ4(8,X)),t.R7$(5),t.Y8G("dataSource",s.dataSource),t.R7$(4),t.Y8G("ngForOf",s.columns),t.R7$(4),t.Y8G("matHeaderRowDef",s.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",s.visibleColumns),t.R7$(1),t.Y8G("pageSize",s.pageSize))},dependencies:[e.Sq,e.bT,y.m,O.T,u.M,m.M,C.s,_.iY,_.$0,M.So,U.An,P.kk,P.fb,P.Cp,A.iy,k.B4,k.aE,a.Zl,a.tL,a.ji,a.cC,a.YV,a.iL,a.KS,a.$R,a.YZ,a.NB]})}}return r})()}];let w=(()=>{class r{static{this.\u0275fac=function(i){return new(i||r)}}static{this.\u0275mod=t.$C({type:r})}static{this.\u0275inj=t.G2t({imports:[h.iI.forChild(J),h.iI]})}}return r})();var Q=o(3632),Z=o(60858),q=o(11801),tt=o(49320),et=o(91398),ot=o(26924),nt=o(5951);let rt=(()=>{class r{static{this.\u0275fac=function(i){return new(i||r)}}static{this.\u0275mod=t.$C({type:r})}static{this.\u0275inj=t.G2t({imports:[e.MD,c.YN,c.X1,ot.YF,d.hM,g.fS,_.Hl,U.m_,nt.Wk,E.Ve]})}}return r})(),it=(()=>{class r{static{this.\u0275fac=function(i){return new(i||r)}}static{this.\u0275mod=t.$C({type:r})}static{this.\u0275inj=t.G2t({imports:[e.MD,w,Q.V,Z.H,q.g,tt.S,et.H,_.Hl,M.g7,U.m_,P.Cn,A.Ou,k.NQ,a.tP,rt,c.YN]})}}return r})()}}]);