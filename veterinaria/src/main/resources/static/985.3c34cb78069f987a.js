"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[985],{74061:(P,f,n)=>{n.d(f,{m:()=>E});var e=n(17705),p=n(60177),r=n(99213),c=n(52920),u=n(18498);function t(d,C){if(1&d&&(e.j41(0,"div",7)(1,"mat-icon",5),e.EFF(2,"chevron_right"),e.k0s(),e.j41(3,"div",6),e.EFF(4),e.k0s()()),2&d){const b=C.$implicit;e.R7$(4),e.JRh(b)}}const y=function(){return["/"]};let E=(()=>{class d{constructor(){this.crumbs=[]}ngOnInit(){}static{this.\u0275fac=function(x){return new(x||d)}}static{this.\u0275cmp=e.VBU({type:d,selectors:[["fury-breadcrumbs"]],inputs:{current:"current",crumbs:"crumbs"},decls:11,vars:5,consts:[[1,"title"],["fxLayout","row","fxLayoutAlign","start center",1,"crumbs"],[1,"crumb","home",3,"routerLink"],["class","crumb","fxLayout","row","fxLayoutAlign","start center",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","start center",1,"crumb","current"],[1,"chevron"],[1,"link"],["fxLayout","row","fxLayoutAlign","start center",1,"crumb"]],template:function(x,v){1&x&&(e.j41(0,"div",0),e.EFF(1),e.k0s(),e.j41(2,"div",1)(3,"a",2),e.EFF(4,"Home"),e.k0s(),e.DNE(5,t,5,1,"div",3),e.j41(6,"div",4)(7,"mat-icon",5),e.EFF(8,"chevron_right"),e.k0s(),e.j41(9,"div",6),e.EFF(10),e.k0s()()()),2&x&&(e.R7$(1),e.JRh(v.current),e.R7$(2),e.Y8G("routerLink",e.lJ4(4,y)),e.R7$(2),e.Y8G("ngForOf",v.crumbs),e.R7$(5),e.JRh(v.current))},dependencies:[p.Sq,r.An,c.DJ,c.sA,u.Wk],styles:["[_nghost-%COMP%]{display:block}.title[_ngcontent-%COMP%]{font:var(--font-title);font-weight:400}.crumb[_ngcontent-%COMP%], .link[_ngcontent-%COMP%]{text-decoration:none;transition:color .4s cubic-bezier(.25,.8,.25,1);font:var(--font-body-1)}.link[_ngcontent-%COMP%]{cursor:pointer}.chevron[_ngcontent-%COMP%]{font-size:18px;height:18px;width:18px;margin-left:6px;margin-right:6px;-webkit-user-select:none;user-select:none;cursor:default}"]})}}return d})()},75063:(P,f,n)=>{n.d(f,{s:()=>O});var e=n(17705),p=n(33726),r=n(23294),c=n(70152),u=n(60177),t=n(99213),y=n(88834),E=n(59115),d=n(82765),C=n(52920),b=n(89417);const x=["filter"];function v(h,M){if(1&h&&(e.j41(0,"div",5)(1,"div",6),e.EFF(2),e.k0s(),e.j41(3,"div",7)(4,"mat-icon",8),e.EFF(5,"search"),e.k0s(),e.nrm(6,"input",9,10),e.k0s(),e.j41(8,"button",11)(9,"mat-icon"),e.EFF(10,"filter_list"),e.k0s()(),e.SdG(11,1),e.k0s()),2&h){const m=e.XpG(),l=e.sdS(3);e.R7$(2),e.JRh(m.name),e.R7$(6),e.Y8G("matMenuTriggerFor",l)}}function T(h,M){if(1&h){const m=e.RV6();e.j41(0,"div",12),e.bIt("click",function(_){const L=e.eBV(m).$implicit,j=e.XpG();return e.Njj(j.toggleColumnVisibility(L,_))}),e.j41(1,"mat-checkbox",13,14),e.bIt("ngModelChange",function(_){const L=e.eBV(m).$implicit;return e.Njj(L.visible=_)})("click",function(_){return _.stopPropagation()}),e.EFF(3),e.k0s()()}if(2&h){const m=M.$implicit;e.R7$(1),e.Y8G("ngModel",m.visible),e.R7$(2),e.SpI(" ",m.name," ")}}const I=["*",[["",8,"actions"]]],k=["*",".actions"];let O=(()=>{class h{constructor(m){this.cd=m,this.filterChange=new e.bkB}ngAfterViewInit(){this.hideHeader||(0,p.R)(this.filter.nativeElement,"keyup").pipe((0,r.F)(),(0,c.B)(150)).subscribe(()=>{this.filterChange.emit(this.filter.nativeElement.value)})}toggleColumnVisibility(m,l){l.stopPropagation(),l.stopImmediatePropagation(),m.visible=!m.visible,this.cd.markForCheck()}static{this.\u0275fac=function(l){return new(l||h)(e.rXU(e.gRc))}}static{this.\u0275cmp=e.VBU({type:h,selectors:[["fury-list"]],viewQuery:function(l,_){if(1&l&&e.GBs(x,5),2&l){let R;e.mGM(R=e.lsd())&&(_.filter=R.first)}},inputs:{name:"name",columns:"columns",hideHeader:"hideHeader"},outputs:{filterChange:"filterChange"},ngContentSelectors:k,decls:6,vars:2,consts:[[1,"fury-list-table"],["class","fury-list-header","fxLayout","row","fxLayoutAlign","start center","fxLayoutGap","8px","fxLayoutGap.gt-xs","24px",4,"ngIf"],["yPosition","below","xPosition","before"],["columnFilter","matMenu"],["class","checkbox-item mat-menu-item",3,"click",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","start center","fxLayoutGap","8px","fxLayoutGap.gt-xs","24px",1,"fury-list-header"],[1,"fury-list-name"],["fxLayout","row","fxLayoutAlign","start center","fxFlex",""],[1,"fury-filter-input-icon"],["fxFlex","","placeholder","Search\u2026",1,"fury-filter-input"],["filter",""],["type","button","mat-icon-button","",1,"fury-column-filter",3,"matMenuTriggerFor"],[1,"checkbox-item","mat-menu-item",3,"click"],[1,"checkbox",3,"ngModel","ngModelChange","click"],["checkbox",""]],template:function(l,_){1&l&&(e.NAR(I),e.j41(0,"div",0),e.DNE(1,v,12,2,"div",1),e.j41(2,"mat-menu",2,3),e.DNE(4,T,4,2,"div",4),e.k0s(),e.SdG(5),e.k0s()),2&l&&(e.R7$(1),e.Y8G("ngIf",!_.hideHeader),e.R7$(3),e.Y8G("ngForOf",_.columns))},dependencies:[u.Sq,u.bT,t.An,y.iY,E.kk,E.Cp,d.So,C.DJ,C.BO,C.sA,C.UI,b.BC,b.vS],styles:[".fury-list-table{display:flex;flex-direction:column}.fury-list-table .fury-list-header{padding-left:24px;padding-right:24px;height:64px;border-top-left-radius:8px;border-top-right-radius:8px}@media screen and (max-width: 599px){.fury-list-table .fury-list-header{height:auto;padding-top:24px;padding-bottom:24px}}.fury-list-table .fury-list-header .fury-list-name{font-size:20px;line-height:32px;font-weight:500;padding-right:24px}@media screen and (max-width: 599px){.fury-list-table .fury-list-header .fury-list-name{border-right:none}}.fury-list-table .fury-list-header .fury-filter-input{font-size:16px;line-height:1.125;border:none;height:32px}.fury-list-table .fury-list-header .fury-filter-input:focus{outline:none}.fury-list-table .fury-list-header .fury-filter-input-icon{width:1.2em;vertical-align:bottom;height:22px;font-size:22px;margin-right:8px}.fury-list-table table{width:100%}.fury-list-table .mat-mdc-header-row .mat-mdc-header-cell .mat-sort-header-button{text-transform:uppercase}.fury-list-table .mat-mdc-cell.image-cell,.fury-list-table .mat-mdc-header-cell.image-cell{flex:0;width:59px}.fury-list-table .mat-mdc-cell.image-cell img,.fury-list-table .mat-mdc-header-cell.image-cell img{border-radius:50%;height:35px;width:35px;margin-right:24px;vertical-align:middle}.fury-list-table .mat-mdc-cell,.fury-list-table .mat-mdc-header-cell{white-space:nowrap;padding-left:12px;padding-right:12px}.fury-list-table .mat-mdc-cell.actions-cell,.fury-list-table .mat-mdc-header-cell.actions-cell{flex:0;width:40px;overflow:visible}.fury-list-table .paginator{display:block}.checkbox-item{padding-right:32px;padding-left:8px}\n"],encapsulation:2})}}return h})()},91398:(P,f,n)=>{n.d(f,{H:()=>u});var e=n(60177),p=n(89417),r=n(12198),c=n(17705);let u=(()=>{class t{static{this.\u0275fac=function(d){return new(d||t)}}static{this.\u0275mod=c.$C({type:t})}static{this.\u0275inj=c.G2t({imports:[e.MD,r.G,p.YN]})}}return t})()},15551:(P,f,n)=>{n.d(f,{M:()=>p});var e=n(17705);let p=(()=>{class r{constructor(){}static{this.\u0275fac=function(t){return new(t||r)}}static{this.\u0275dir=e.FsC({type:r,selectors:[["","furyPageLayoutContent",""],["fury-page-layout-content"]],hostAttrs:[1,"fury-page-layout-content"]})}}return r})()},53007:(P,f,n)=>{n.d(f,{M:()=>p});var e=n(17705);let p=(()=>{class r{constructor(){}static{this.\u0275fac=function(t){return new(t||r)}}static{this.\u0275dir=e.FsC({type:r,selectors:[["","furyPageLayoutHeader",""],["fury-page-layout-header"]],hostAttrs:[1,"fury-page-layout-header"]})}}return r})()},43655:(P,f,n)=>{n.d(f,{T:()=>p});var e=n(17705);let p=(()=>{class r{constructor(){this.mode="simple"}get isCard(){return"card"===this.mode}get isSimple(){return"simple"===this.mode}static{this.\u0275fac=function(t){return new(t||r)}}static{this.\u0275dir=e.FsC({type:r,selectors:[["","furyPageLayout",""],["fury-page-layout"]],hostAttrs:[1,"fury-page-layout"],hostVars:4,hostBindings:function(t,y){2&t&&e.AVh("fury-page-layout-card",y.isCard)("fury-page-layout-simple",y.isSimple)},inputs:{mode:"mode"}})}}return r})()},17985:(P,f,n)=>{n.r(f),n.d(f,{EstanteModule:()=>Z});var e=n(60177),p=n(18498),r=n(9159),c=n(89417),u=n(34006),t=n(17705),y=n(52920),E=n(88834),d=n(86467),C=n(99631);function b(i,g){if(1&i&&(t.j41(0,"button",8),t.EFF(1,"Registrar Estante "),t.k0s()),2&i){const o=t.XpG();t.Y8G("disabled",!o.form.valid)}}function x(i,g){if(1&i&&(t.j41(0,"button",8),t.EFF(1,"Actualizar Estante "),t.k0s()),2&i){const o=t.XpG();t.Y8G("disabled",!o.form.valid)}}let v=(()=>{class i{constructor(o,a){this.defaults=o,this.dialogRef=a,this.mode="create"}ngOnInit(){this.defaults?this.mode="update":this.defaults={},this.form=new c.J3({nombre:new c.hs(this.defaults.nombre),descripcion:new c.hs(this.defaults.descripcion)})}save(){console.log(this.form.value),"create"===this.mode?this.createCustomer():"update"===this.mode&&this.updateCustomer()}createCustomer(){this.dialogRef.close(this.form.value)}updateCustomer(){const o=this.form.value;o.id=this.defaults.id,this.dialogRef.close(o)}isCreateMode(){return"create"===this.mode}isUpdateMode(){return"update"===this.mode}static{this.\u0275fac=function(a){return new(a||i)(t.rXU(u.Vh),t.rXU(u.CP))}}static{this.\u0275cmp=t.VBU({type:i,selectors:[["fury-crear-actualizar-estante"]],decls:16,vars:4,consts:[["mat-dialog-title",""],[3,"formGroup","ngSubmit"],["fxLayout","column wrap"],["fxFlex",""],["type","text","formControlName","nombre","matInput",""],["type","text","formControlName","descripcion","matInput",""],["fxLayout","row","fxLayoutAlign","end center"],["mat-flat-button","","color","primary",3,"disabled",4,"ngIf"],["mat-flat-button","","color","primary",3,"disabled"]],template:function(a,s){1&a&&(t.j41(0,"div",0),t.EFF(1),t.k0s(),t.j41(2,"form",1),t.bIt("ngSubmit",function(){return s.save()}),t.j41(3,"mat-dialog-content")(4,"div",2)(5,"mat-form-field",3)(6,"mat-label"),t.EFF(7,"Nombre"),t.k0s(),t.nrm(8,"input",4),t.k0s(),t.j41(9,"mat-form-field",3)(10,"mat-label"),t.EFF(11,"Descripcion"),t.k0s(),t.nrm(12,"input",5),t.k0s()()(),t.j41(13,"mat-dialog-actions",6),t.DNE(14,b,2,1,"button",7),t.DNE(15,x,2,1,"button",7),t.k0s()()),2&a&&(t.R7$(1),t.SpI("",s.isCreateMode()?"Crear":"Actualizar"," Estante"),t.R7$(1),t.Y8G("formGroup",s.form),t.R7$(12),t.Y8G("ngIf",s.isCreateMode()),t.R7$(1),t.Y8G("ngIf",s.isUpdateMode()))},dependencies:[e.bT,y.DJ,y.sA,y.UI,E.$z,u.BI,u.Yi,u.E7,d.rl,d.nJ,C.fg,c.qT,c.me,c.BC,c.cb,c.j4,c.JD]})}}return i})();var T=n(97405),I=n(74061),k=n(75063),O=n(82765),h=n(99213),M=n(59115),m=n(96695),l=n(2042),_=n(43655),R=n(53007),L=n(15551);function j(i,g){1&i&&(t.j41(0,"th",15)(1,"mat-checkbox",16),t.bIt("click",function(a){return a.stopPropagation()}),t.k0s()())}function A(i,g){1&i&&(t.j41(0,"td",17)(1,"mat-checkbox",16),t.bIt("click",function(a){return a.stopPropagation()}),t.k0s()())}function G(i,g){if(1&i&&(t.j41(0,"th",22),t.EFF(1),t.k0s()),2&i){const o=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o.name,"")}}function B(i,g){if(1&i&&(t.j41(0,"td",23),t.EFF(1),t.k0s()),2&i){const o=g.$implicit,a=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o[a.property]," ")}}function $(i,g){if(1&i&&(t.qex(0,19),t.DNE(1,G,2,1,"th",20),t.DNE(2,B,2,1,"td",21),t.bVm()),2&i){const o=t.XpG().$implicit;t.Y8G("matColumnDef",o.property)}}function S(i,g){if(1&i&&(t.qex(0),t.DNE(1,$,3,1,"ng-container",18),t.bVm()),2&i){const o=g.$implicit;t.R7$(1),t.Y8G("ngIf",o.isModelProperty)}}function U(i,g){1&i&&t.nrm(0,"th",24)}function N(i,g){if(1&i){const o=t.RV6();t.j41(0,"td",17)(1,"button",25),t.bIt("click",function(s){return s.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",26,27)(6,"button",28),t.bIt("click",function(){const D=t.eBV(o).$implicit,F=t.XpG();return t.Njj(F.updateEstante(D))}),t.j41(7,"span"),t.EFF(8,"Modify"),t.k0s()(),t.j41(9,"button",28),t.bIt("click",function(){const D=t.eBV(o).$implicit,F=t.XpG();return t.Njj(F.deleteEstante(D))}),t.j41(10,"span"),t.EFF(11,"Delete"),t.k0s()()()()}if(2&i){const o=t.sdS(5);t.R7$(1),t.Y8G("matMenuTriggerFor",o)}}function Y(i,g){1&i&&t.nrm(0,"tr",29)}function K(i,g){if(1&i){const o=t.RV6();t.j41(0,"tr",30),t.bIt("click",function(){const D=t.eBV(o).$implicit,F=t.XpG();return t.Njj(F.updateEstante(D))}),t.k0s()}}const V=function(){return["Estantes"]},W=function(){return[]},z=[{path:"",component:(()=>{class i{ngOnInit(){this.getEstantes()}get visibleColumns(){return this.columns.filter(o=>o.visible).map(o=>o.property)}constructor(o,a){this.apiClient=o,this.dialog=a,this.dataSource=new r.I6([]),this.columns=[{name:"ID",property:"id",visible:!0,isModelProperty:!0},{name:"Nombre",property:"nombre",visible:!0,isModelProperty:!0},{name:"Descripcion",property:"descripcion",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0}],this.pageSize=10}getEstantes(){this.apiClient.getRequest("/api/estante").subscribe({next:o=>{this.dataSource.data=o,console.log(o)},error:o=>{console.error(o)}})}createEstante(){console.info("Abre dialogo de creacion"),this.dialog.open(v,{width:"400px"}).afterClosed().subscribe(o=>{o?(console.info("Al cerrar",o),this.apiClient.postRequest("/api/estante",o).subscribe({next:a=>{console.info("OK",a),this.getEstantes()},error:a=>{console.error("error",a)}}),console.info("Fin api call")):console.info("Cancelado"),console.info("Fin Metodo")})}updateEstante(o){console.info(o),this.dialog.open(v,{data:o,width:"400px"}).afterClosed().subscribe(a=>{a?this.apiClient.putRequest("/api/estante",a.id,a).subscribe({next:s=>{this.getEstantes()},error:s=>{console.info(s)}}):console.info("Cancelado")})}deleteEstante(o){console.info("deleteServicio",o),this.apiClient.deleteRequest(o.id,"/api/estante").subscribe({next:a=>{this.getEstantes()},error:a=>{console.info(a)}})}onFilterChange(o){console.info(event),this.dataSource&&(o=(o=o.trim()).toLowerCase(),this.dataSource.filter=o)}static{this.\u0275fac=function(a){return new(a||i)(t.rXU(T.f),t.rXU(u.bZ))}}static{this.\u0275cmp=t.VBU({type:i,selectors:[["fury-estante"]],decls:20,vars:9,consts:[["mode","card"],["current","Estante",3,"crumbs"],["name","Estante",3,"columns","filterChange"],[1,"actions"],["type","button","mat-mini-fab","","color","primary",1,"create",3,"click"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","checkbox"],["class","actions-cell","mat-header-cell","",4,"matHeaderCellDef"],["class","actions-cell","mat-cell","",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions"],["class","actions-cell","mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["class","clickable route-animations-elements","mat-row","",3,"click",4,"matRowDef","matRowDefColumns"],[1,"paginator",3,"pageSize"],["mat-header-cell","",1,"actions-cell"],["color","primary",3,"click"],["mat-cell","",1,"actions-cell"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-cell","","mat-sort-header","",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu","matMenu"],["mat-menu-item","",3,"click"],["mat-header-row",""],["mat-row","",1,"clickable","route-animations-elements",3,"click"]],template:function(a,s){1&a&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2),t.bIt("filterChange",function(F){return s.onFilterChange(F)}),t.j41(5,"div",3)(6,"button",4),t.bIt("click",function(){return s.createEstante()}),t.j41(7,"mat-icon"),t.EFF(8,"add"),t.k0s()()(),t.j41(9,"table",5),t.qex(10,6),t.DNE(11,j,2,0,"th",7),t.DNE(12,A,2,0,"td",8),t.bVm(),t.DNE(13,S,2,1,"ng-container",9),t.qex(14,10),t.DNE(15,U,1,0,"th",11),t.DNE(16,N,12,1,"td",8),t.bVm(),t.DNE(17,Y,1,0,"tr",12),t.DNE(18,K,1,0,"tr",13),t.k0s(),t.nrm(19,"mat-paginator",14),t.k0s()()()),2&a&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(7,V)),t.R7$(2),t.Y8G("columns",t.lJ4(8,W)),t.R7$(5),t.Y8G("dataSource",s.dataSource),t.R7$(4),t.Y8G("ngForOf",s.columns),t.R7$(4),t.Y8G("matHeaderRowDef",s.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",s.visibleColumns),t.R7$(1),t.Y8G("pageSize",s.pageSize))},dependencies:[e.Sq,e.bT,I.m,k.s,E.iY,E.$0,O.So,h.An,M.kk,M.fb,M.Cp,m.iy,l.B4,l.aE,r.Zl,r.tL,r.ji,r.cC,r.YV,r.iL,r.KS,r.$R,r.YZ,r.NB,_.T,R.M,L.M]})}}return i})()}];let w=(()=>{class i{static{this.\u0275fac=function(a){return new(a||i)}}static{this.\u0275mod=t.$C({type:i})}static{this.\u0275inj=t.G2t({imports:[p.iI.forChild(z),p.iI]})}}return i})();var H=n(3632),X=n(91398),J=n(49320);let Q=(()=>{class i{static{this.\u0275fac=function(a){return new(a||i)}}static{this.\u0275mod=t.$C({type:i})}static{this.\u0275inj=t.G2t({imports:[e.MD,y.w2,E.Hl,u.hM,d.RG,C.fS,c.X1]})}}return i})(),Z=(()=>{class i{static{this.\u0275fac=function(a){return new(a||i)}}static{this.\u0275mod=t.$C({type:i})}static{this.\u0275inj=t.G2t({imports:[e.MD,w,H.V,X.H,E.Hl,O.g7,h.m_,M.Cn,m.Ou,l.NQ,r.tP,J.S,Q]})}}return i})()}}]);