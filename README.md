How to run the project (example)
```bash
minikube start
kubectl create secret generic database-secrets --from-literal=username=test --from-literal=password='test' --from-literal=database='test'
kubectl create secret generic grafana --from-literal=gf_security_admin_user='admin' --from-literal=gf_security_admin_password='grafana'
cd .\monitoring\
kubectl apply -f deployment.yaml
kubectl port-forward sergeyttser-api-6dbcffcb87-d28zg 8080:8080 (replace with your pod name)
kubectl port-forward sergeyttser-api-6dbcffcb87-d28zg 9091:9091 (replace with your pod name)
```
